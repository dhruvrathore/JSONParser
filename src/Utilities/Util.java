package Utilities;

public class Util {

	public static String capitalize(String toCapitalize){
		if(toCapitalize.isEmpty())
			return toCapitalize;
		return toCapitalize.substring(0, 1).toUpperCase()+toCapitalize.substring(1);
	}
}
