package entity;

public class Token {
	private int tokenType;
	private String token;
	
	public Token(int tokenType, String token) {
		super();
		this.tokenType = tokenType;
		this.token = token;
	}

	public int getTokenType() {
		return tokenType;
	}
	
	public void setTokenType(int tokenType) {
		this.tokenType = tokenType;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", token=" + token + "]";
	}
	
	

}
