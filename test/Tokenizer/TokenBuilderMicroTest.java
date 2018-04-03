package Tokenizer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Parser.ParserException;
import entity.Token;
import entity.TokenConstants;
import org.junit.Assert;

public class TokenBuilderMicroTest {

	@Test
	public void testCreateTokensForString() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\"}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "name"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "John"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForStringWithSpaces() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("  { \"name\":\"John Lang \" } ");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "name"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "John Lang "));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test(expected = Exception.class)
	public void testCreateTokensForInvalidTokens() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		tokenBuilder.createTokens("{\"name\";\"John\"}");
	}
	
	@Test
	public void testCreateTokensForInteger() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"age\":32}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "age"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.NUMBERIDENTIFIER, "32"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForDouble() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"fraction\":-577.44}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "fraction"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.NUMBERIDENTIFIER, "-577.44"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForTrue() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"isValid\":true}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "isValid"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.TRUEIDENTIFIER, "true"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForFalse() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"isValid\":false}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "isValid"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.FALSEIDENTIFIER, "false"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForArray() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{  \"cars\":[\"Ford\",\"BMW\",\"Fiat\"]  }");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "cars"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.OPENSQUARE, "["));		
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "Ford"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "BMW"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "Fiat"));
		expectedTokens.add(new Token(TokenConstants.CLOSESQUARE, "]"));		
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}

	@Test
	public void testCreateTokensForNull() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"nullable\":null}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "nullable"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.NULLIDENTIFIER, "null"));
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
	
	@Test
	public void testCreateTokensForNested() throws Exception{
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		List<Token> expectedTokens = new ArrayList<>();
		expectedTokens.add(new Token(TokenConstants.OPENCURLY, "{"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "name"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "John"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "age"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.NUMBERIDENTIFIER, "30"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "cars"));
		expectedTokens.add(new Token(TokenConstants.SEPARATOR, ":"));
		expectedTokens.add(new Token(TokenConstants.OPENSQUARE, "["));		
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "Ford"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "BMW"));
		expectedTokens.add(new Token(TokenConstants.COMMA, ","));
		expectedTokens.add(new Token(TokenConstants.STRINGIDENTIFIER, "Fiat"));
		expectedTokens.add(new Token(TokenConstants.CLOSESQUARE, "]"));		
		expectedTokens.add(new Token(TokenConstants.CLOSECURLY, "}"));
		Assert.assertEquals(expectedTokens,tokens);
	}
}
