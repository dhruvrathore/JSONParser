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
	
	
	public String getToken() {
		return token;
	}
	

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", token=" + token + "]";
	}
	
	@Override
	public Token clone(){
		return new Token(this.tokenType,this.token);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + tokenType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokenType != other.tokenType)
			return false;
		return true;
	}

}
