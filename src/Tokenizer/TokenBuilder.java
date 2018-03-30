package Tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Token;

public class TokenBuilder {
	
	List<TokenInfo> listTokenInfo;
	
	public TokenBuilder(){
		listTokenInfo = new ArrayList<>();
		TokenFill.fill(this);
	}
	
	public void add(String regex, int tokenType){
		TokenInfo tokenInfo = new TokenInfo(Pattern.compile("^("+regex+")"), tokenType);
		listTokenInfo.add(tokenInfo);
	}
	
	public List<Token> createTokens(String jsonStr) throws Exception{
		List<Token> tokens = new ArrayList<>();
		while(!jsonStr.isEmpty()){
			boolean isFound = false;
			for(TokenInfo tokenInfo: listTokenInfo){
				Matcher matcher = tokenInfo.getRegex().matcher(jsonStr);
				if(matcher.find()){
					tokens.add(new Token(tokenInfo.getTokenType(), matcher.group().trim()));
					jsonStr = matcher.replaceFirst("");
					isFound = true;
					break;
				}
			}
			if(isFound == false)
				throw new Exception("JSON string is invalid");
		}
		return tokens;
	}

}
