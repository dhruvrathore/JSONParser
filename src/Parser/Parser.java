package Parser;

import java.util.List;

import entity.Token;
import entity.TokenConstants;

public class Parser {
	List<Token> tokens;
	Token lookAhead = null;
	
	public Parser(List<Token> tokens){
		this.tokens = tokens;	
	}
	
	private void getNextToken(){
		if(tokens!=null && !tokens.isEmpty()){
			lookAhead = tokens.get(0);
			tokens.remove(0);
		}
		else{
			lookAhead = new Token(TokenConstants.EPSILON, "");
		}
	}
	
	public void validate() throws Exception{
		getNextToken();
		object();
		if(lookAhead.getTokenType()!=TokenConstants.EPSILON)
			throw new Exception("Error in JSON"+lookAhead.getToken());
	}
	
	private void object() throws ParserException{
		// constructor of class should be called here
		if(lookAhead.getTokenType()==TokenConstants.OPENCURLY){
			// object => { BA }
			getNextToken();
			keyValuePair();
			commaSeparation();
			if(lookAhead.getTokenType()==TokenConstants.CLOSECURLY){
				getNextToken();
			}else{
				ParserException.throwException("Error in JSON"+lookAhead.getToken());
			}
		}else{
			ParserException.throwException("Error in JSON"+lookAhead.getToken());
		}
	}
	
	private void commaSeparation() throws ParserException {
		if(lookAhead.getTokenType()==TokenConstants.COMMA){
			// A-> , BA
			getNextToken();
			keyValuePair();
			commaSeparation();
		}else{
			// A-> epsilon
		}
	}

	private void keyValuePair() throws ParserException{
		if(lookAhead.getTokenType()==TokenConstants.STRINGIDENTIFIER){
			// B -> "" : V
			getNextToken();
			if(lookAhead.getTokenType()==TokenConstants.SEPARATOR){
				getNextToken();
				value();
			}else{
				ParserException.throwException("Error in JSON"+lookAhead.getToken());
			}
		}else{
			ParserException.throwException("Error in JSON"+lookAhead.getToken());
		}
	}

	private void value() throws ParserException {
		if(lookAhead.getTokenType()==TokenConstants.OPENCURLY){
			// V -> object
			object();
		}else if(lookAhead.getTokenType()==TokenConstants.NULLIDENTIFIER || lookAhead.getTokenType()==TokenConstants.TRUEIDENTIFIER || lookAhead.getTokenType()==TokenConstants.FALSEIDENTIFIER || lookAhead.getTokenType()==TokenConstants.STRINGIDENTIFIER || lookAhead.getTokenType()==TokenConstants.NUMBERIDENTIFIER){
			// V-> null | true | false | string | number
			// return new JSONObject(lookAhead.getToken());
			getNextToken();
		}else if(lookAhead.getTokenType()==TokenConstants.OPENSQUARE){
			// V-> [V Val]
			getNextToken();
			value();
			arrayContinuer();
			if(lookAhead.getTokenType()==TokenConstants.CLOSESQUARE){
				getNextToken();
			}else{
				ParserException.throwException("Error in JSON"+lookAhead.getToken());
			}
		}else{
			ParserException.throwException("Error in JSON"+lookAhead.getToken());
		}
	}

	private void arrayContinuer() throws ParserException {
		if(lookAhead.getTokenType()==TokenConstants.COMMA){
			// Val -> , V Val
			getNextToken();
			value();
			arrayContinuer();
		}else{
			//Val -> epsilon
		}	
	}
}
 