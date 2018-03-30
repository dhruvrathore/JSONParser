package Tokenizer;

import java.util.regex.Pattern;

public class TokenInfo {
	
	private Pattern regex;
	private int tokenType;
	
	public TokenInfo(Pattern regex,int tokenType){
		this.regex = regex;
		this.tokenType = tokenType;
	}

	public Pattern getRegex() {
		return regex;
	}

	public int getTokenType() {
		return tokenType;
	}
	
	

}
