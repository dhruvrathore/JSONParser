package bootstrap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import entity.JSONObject;
import test.entity.TestJSONObject;

public class ParserMicroTest {

	@Test
	public void testParser() throws Exception{
		TestJSONObject expectedObject = new TestJSONObject();
		expectedObject.setName("John");
		expectedObject.setAge(30);
		expectedObject.setCars(Arrays.asList("Ford","BMW","Fiat"));
		String jsonText = "{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}";
		Object obj = Parser.parse(jsonText, TestJSONObject.class);
		Assert.assertEquals(expectedObject,obj);
	}
}
