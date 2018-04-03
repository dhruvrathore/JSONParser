package bootstrap;

import java.text.ParseException;
import java.util.List;

import Parser.TreeParser;
import Tokenizer.TokenBuilder;
import entity.JSONObject;
import entity.Token;
import test.entity.TestJSONObject;

public class AppMain {

	public static void main(String[] args) throws Exception {
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		TreeParser parser = new TreeParser(tokens);
		try{
			JSONObject obj = parser.parse(TestJSONObject.class);
			System.out.println(obj.getValue());
		}catch(ParseException e){
			System.out.println("Error Occurred"+e.getMessage());
		}
	}

}
