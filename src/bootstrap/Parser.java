package bootstrap;

import java.util.List;

import Parser.TreeParser;
import Tokenizer.TokenBuilder;
import entity.JSONObject;
import entity.Token;
import test.entity.TestJSONObject;

public class Parser {

	public static Object parse(String jsonText, Class parseClass) throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(TestJSONObject.class);
		return obj.getValue();
	}
}
