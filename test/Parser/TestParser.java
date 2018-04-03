package Parser;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Tokenizer.TokenBuilder;
import entity.Token;

public class TestParser {

	@Test
	public void testparsing() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		try{
			parser.validate();
		}catch(ParseException e){
			Assert.fail("Should not throw Exception");
		}
	}
	@Test(expected = ParserException.class)
	public void testparsingWithExceptionArrayNotComplete() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"}");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		parser.validate();
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithExceptionClosedCurlyBracesNotPresent() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		parser.validate();
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithNoOpeningBraces() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"}");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		parser.validate();
	}
	
	@Test(expected = ParserException.class)
	public void testparsingWithNoSeparator() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("\"name\"\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"}");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		parser.validate();
	}
	
}
