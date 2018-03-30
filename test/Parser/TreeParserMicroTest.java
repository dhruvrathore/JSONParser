package Parser;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Tokenizer.TokenBuilder;
import entity.JSONObject;
import entity.NestedJSONTest;
import entity.TestJSONObject;
import entity.Token;

public class TreeParserMicroTest {

	@Test
	public void testparsing() throws Exception{
		
		TestJSONObject expectedObject = new TestJSONObject();
		expectedObject.setName("John");
		expectedObject.setAge(30);
		expectedObject.setCars(Arrays.asList("Ford","BMW","Fiat"));
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		System.out.println(tokens);
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(TestJSONObject.class);
		Assert.assertEquals(expectedObject,obj.getValue());
		
	}
	
	@Test
	public void testParsingNested() throws Exception{
		String JSON = "{\"name\":\"John\",\"age\":31,\"Country\":{\"india\":{\"cities\":[\"jaipur\",\"delhi\",\"gzb\",\"noida\"]},\"usa\":{\"cities\":[\"new york\",\"florida\",\"maimi\"]}}}";
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens(JSON);
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(NestedJSONTest.class);
		System.out.println(obj.getValue());
	}
}
