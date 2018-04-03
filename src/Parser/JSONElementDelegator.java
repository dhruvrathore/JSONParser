package Parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Reflection.PrimitiveToClassConverter;
import entity.BooleanJSONElement;
import entity.JSONElement;
import entity.JSONObject;
import entity.NullJSONElement;
import entity.NumericJSONElement;
import entity.StringJSONElement;
import entity.Token;
import entity.TokenConstants;

public class JSONElementDelegator {

	public static JSONElement fetchJSONElementAndExecuteMethod(Token token,String type){
		if(token.getTokenType() == TokenConstants.NULLIDENTIFIER){
			return new NullJSONElement();
		}
		else if(token.getTokenType() == TokenConstants.TRUEIDENTIFIER || token.getTokenType()==TokenConstants.FALSEIDENTIFIER){
			return new BooleanJSONElement(Boolean.valueOf(token.getToken()));
		}
		else if(token.getTokenType()==TokenConstants.NUMBERIDENTIFIER){
			return new NumericJSONElement(PrimitiveToClassConverter.convertToClass(token.getToken(),type),type);
		}
		else if(token.getTokenType()==TokenConstants.STRINGIDENTIFIER){
			return new StringJSONElement(token.getToken());
		}
		return null;
	}
}
