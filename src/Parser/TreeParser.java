package Parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import Utilities.Util;
import entity.ClassField;
import entity.JSONArray;
import entity.JSONElement;
import entity.JSONObject;
import entity.StringJSONElement;
import entity.Token;
import entity.TokenConstants;

public class TreeParser {
	List<Token> tokens;
	Token lookAhead = null;
	
	public TreeParser(List<Token> tokens){
		this.tokens = tokens;	
	}
	
	private void getNextToken(){
		if(tokens!=null && !tokens.isEmpty()){
			lookAhead = tokens.get(0);
			System.out.println(lookAhead.getToken());
			tokens.remove(0);
		}
		else{
			lookAhead = new Token(TokenConstants.EPSILON, "");
		}
	}
	
	public JSONObject parse(Class parseClass) throws Exception{
		getNextToken();
		JSONObject parsedObject = object(parseClass);
		if(lookAhead.getTokenType()!=TokenConstants.EPSILON)
			throw new Exception("Error in JSON"+lookAhead.getToken());
		return parsedObject;
	}
	
	private JSONObject object(Class parseClass) throws ParserException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		// constructor of class should be called here
		JSONObject inProcessObj = null;
		if(lookAhead.getTokenType()==TokenConstants.OPENCURLY){
			// object => { BA }
			inProcessObj = new JSONObject(parseClass.newInstance(),parseClass);
			getNextToken();
			keyValuePair(inProcessObj);
			commaSeparation(inProcessObj);
			if(lookAhead.getTokenType()==TokenConstants.CLOSECURLY){
				getNextToken();
			}else{
				ParserException.throwException("Error in JSON"+lookAhead.getToken());
			}
		}else{
			ParserException.throwException("Error in JSON"+lookAhead.getToken());
		}
		return inProcessObj;
	}
	
	private void commaSeparation(JSONObject inProcessObj) throws ParserException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		if(lookAhead.getTokenType()==TokenConstants.COMMA){
			// A-> , BA
			getNextToken();
			keyValuePair(inProcessObj);
			commaSeparation(inProcessObj);
		}else{
			// A-> epsilon
		}
	}

	private void keyValuePair(JSONObject inProcessObj) throws ParserException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
		if(lookAhead.getTokenType()==TokenConstants.STRINGIDENTIFIER){
			// B -> "" : V
			ClassField fieldForKey = inProcessObj.getClassField(lookAhead.getToken());
			getNextToken();
			if(lookAhead.getTokenType()==TokenConstants.SEPARATOR){
				getNextToken();
				Class inProcessObjectClass = inProcessObj.getClassHolder();
				Method setter = inProcessObjectClass.getMethod("set"+Util.capitalize(fieldForKey.getNameOfField()), fieldForKey.getType().getType());
				JSONElement valueToSet = value(fieldForKey);
				setter.invoke(inProcessObj.getValue(), valueToSet.getValue());
					
			}else{
				ParserException.throwException("Error in JSON"+lookAhead.getToken());
			}
		}else{
			ParserException.throwException("Error in JSON"+lookAhead.getToken());
		}
	}

	private JSONElement value(ClassField fieldForKey) throws InstantiationException, IllegalAccessException, ParserException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		if(lookAhead.getTokenType()==TokenConstants.OPENCURLY){
			// V -> object
			return object(fieldForKey.getType().getType());
		}else if(lookAhead.getTokenType()==TokenConstants.NULLIDENTIFIER || lookAhead.getTokenType()==TokenConstants.TRUEIDENTIFIER || lookAhead.getTokenType()==TokenConstants.FALSEIDENTIFIER || lookAhead.getTokenType()==TokenConstants.STRINGIDENTIFIER || lookAhead.getTokenType()==TokenConstants.NUMBERIDENTIFIER){
			// V-> null | true | false | string | number
			Token literal = lookAhead.clone();
			getNextToken();
			return JSONElementDelegator.fetchJSONElementAndExecuteMethod(literal,fieldForKey.getType().getType().getName());
		}else if(lookAhead.getTokenType()==TokenConstants.OPENSQUARE){
			// V-> [V Val]
			JSONArray jsonArray = new JSONArray();
			getNextToken();
			jsonArray.add(value(fieldForKey));
			arrayContinuer(jsonArray,fieldForKey);
			if(lookAhead.getTokenType()==TokenConstants.CLOSESQUARE){
				getNextToken();
				return jsonArray;
			}
		}
		ParserException.throwException("Error in JSON"+lookAhead.getToken());
		return null;
	}

	private void arrayContinuer(JSONArray jsonArray,ClassField fieldForKey) throws ParserException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		if(lookAhead.getTokenType()==TokenConstants.COMMA){
			// Val -> , V Val
			getNextToken();
			jsonArray.add(value(fieldForKey));
			arrayContinuer(jsonArray,fieldForKey);
		}else{
			//Val -> epsilon
		}	
	}
}
