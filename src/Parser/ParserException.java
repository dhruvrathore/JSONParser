package Parser;

public class ParserException extends Exception{
	public ParserException(String msg) {
		super(msg);
	}

	public static void throwException(String msg) throws ParserException{
		throw new ParserException(msg);
	}
}
