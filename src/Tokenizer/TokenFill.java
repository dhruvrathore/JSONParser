package Tokenizer;

import entity.TokenConstants;

public class TokenFill {

	public static void fill(TokenBuilder tokenBuilder){
		tokenBuilder.add(",", TokenConstants.COMMA);
		tokenBuilder.add("\\{", TokenConstants.OPENCURLY);
		tokenBuilder.add("\\}", TokenConstants.CLOSECURLY);
		tokenBuilder.add("\\[", TokenConstants.OPENSQUARE);
		tokenBuilder.add("\\]", TokenConstants.CLOSESQUARE);
		tokenBuilder.add(":", TokenConstants.SEPARATOR);
		tokenBuilder.add("null", TokenConstants.NULLIDENTIFIER);
		tokenBuilder.add("true", TokenConstants.TRUEIDENTIFIER);
		tokenBuilder.add("false", TokenConstants.FALSEIDENTIFIER);
		tokenBuilder.add("[0-9]+(\\.[0-9]+)?", TokenConstants.NUMBERIDENTIFIER);
		tokenBuilder.add("\"[a-z A-Z]+\"", TokenConstants.STRINGIDENTIFIER);
	}
}
