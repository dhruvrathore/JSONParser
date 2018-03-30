package Parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import entity.BooleanJSONElement;
import entity.JSONElement;
import entity.JSONObject;
import entity.NullJSONElement;
import entity.NumericJSONElement;
import entity.StringJSONElement;
import entity.Token;
import entity.TokenConstants;

public class JSONElementDelegator {

	public static JSONElement fetchJSONElementAndExecuteMethod(Token token){
		if(token.getTokenType() == TokenConstants.NULLIDENTIFIER){
			return new NullJSONElement();
		}
		else if(token.getTokenType() == TokenConstants.TRUEIDENTIFIER || token.getTokenType()==TokenConstants.FALSEIDENTIFIER){
			return new BooleanJSONElement(Boolean.getBoolean(token.getToken()));
		}
		else if(token.getTokenType()==TokenConstants.NUMBERIDENTIFIER){
			return new NumericJSONElement(Integer.valueOf(token.getToken()));
		}
		else if(token.getTokenType()==TokenConstants.STRINGIDENTIFIER){
			return new StringJSONElement(token.getToken());
		}
		return null;
	}
}
