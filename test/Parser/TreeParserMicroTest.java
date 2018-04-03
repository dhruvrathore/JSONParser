package Parser;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Tokenizer.TokenBuilder;
import entity.JSONObject;
import entity.Token;
import test.entity.BooleanEntity;
import test.entity.CountriesCity;
import test.entity.Country;
import test.entity.FloatMockObject;
import test.entity.NestedJSONTest;
import test.entity.TestJSONObject;

public class TreeParserMicroTest {

	@Test
	public void testparsing() throws Exception{
		TestJSONObject expectedObject = new TestJSONObject();
		expectedObject.setName("John");
		expectedObject.setAge(30);
		expectedObject.setCars(Arrays.asList("Ford","BMW","Fiat"));
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(TestJSONObject.class);
		Assert.assertEquals(expectedObject,obj.getValue());		
	}
	
	@Test
	public void testparsingWithBoolean() throws Exception{
		
		BooleanEntity expectedObject = new BooleanEntity(true);
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{ \"isBool\":true }");
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(BooleanEntity.class);
		Assert.assertEquals(expectedObject,obj.getValue());
	}
	
	@Test
	public void testparsingForFloat() throws Exception{
		
		FloatMockObject expectedObject = new FloatMockObject();
		expectedObject.setName("John");
		expectedObject.setAge(30.04f);
		expectedObject.setCars(Arrays.asList("Ford","BMW","Fiat"));
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30.04,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		System.out.println(tokens);
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(FloatMockObject.class);
		Assert.assertEquals(expectedObject,obj.getValue());
		
	}
	
	@Test
	public void testParsingNested() throws Exception{
		String JSON = "{\"name\":\"John\",\"age\":31,\"Country\":{\"india\":{\"cities\":[\"jaipur\",\"delhi\",\"gzb\",\"noida\"]},\"usa\":{\"cities\":[\"new york\",\"florida\",\"miami\"]}}}";
		NestedJSONTest jsonObject = new NestedJSONTest();
		jsonObject.setName("John");
		jsonObject.setAge(31);
		
		CountriesCity india = new CountriesCity();
		india.setCities(Arrays.asList("jaipur","delhi","gzb","noida"));
		CountriesCity usa = new CountriesCity();
		usa.setCities(Arrays.asList("new york","florida","miami"));
		Country country = new Country();
		country.setIndia(india);
		country.setUsa(usa);
		
		jsonObject.setCountry(country);
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens(JSON);
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(NestedJSONTest.class);
		System.out.println(obj.getValue());
		Assert.assertEquals(jsonObject, obj.getValue());
	}
	
	@Test
	public void testParsingNestedWithNull() throws Exception{
		String JSON = "{\"name\":null,\"age\":31,\"Country\":{\"india\":{\"cities\":[\"jaipur\",\"delhi\",\"gzb\",\"noida\"]},\"usa\":{\"cities\":[\"new york\",\"florida\",\"miami\"]}}}";
		NestedJSONTest jsonObject = new NestedJSONTest();
		jsonObject.setName(null);
		jsonObject.setAge(31);
		
		CountriesCity india = new CountriesCity();
		india.setCities(Arrays.asList("jaipur","delhi","gzb","noida"));
		CountriesCity usa = new CountriesCity();
		usa.setCities(Arrays.asList("new york","florida","miami"));
		Country country = new Country();
		country.setIndia(india);
		country.setUsa(usa);
		
		jsonObject.setCountry(country);
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens(JSON);
		TreeParser parser = new TreeParser(tokens);
		JSONObject obj = parser.parse(NestedJSONTest.class);
		Assert.assertEquals(jsonObject, obj.getValue());
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithNoSeparator() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\" \"John\"}");
		TreeParser parser = new TreeParser(tokens);
		parser.parse(TestJSONObject.class);
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithNoOpenCurly() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"}");
		TreeParser parser = new TreeParser(tokens);
		parser.parse(TestJSONObject.class);
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithNoTokens() throws Exception{
		TreeParser parser = new TreeParser(null);
		parser.parse(TestJSONObject.class);
	}
}
