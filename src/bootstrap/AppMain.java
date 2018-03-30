package bootstrap;

import java.text.ParseException;
import java.util.List;

import Parser.Parser;
import Tokenizer.TokenBuilder;
import entity.Token;

public class AppMain {

	public static void main(String[] args) throws Exception {
		TokenBuilder tokenBuilder = new TokenBuilder();
		List<Token> tokens = tokenBuilder.createTokens("{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"]}");
		System.out.println(tokens);
		Parser parser = new Parser(tokens);
		try{
			parser.parse();
		}catch(ParseException e){
			System.out.println("Error Occurred"+e.getMessage());
		}
	}

}
