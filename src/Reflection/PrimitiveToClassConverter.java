package Reflection;
/**
 * 
int int
double double
byte byte
name java.lang.String
int[] [I
doubles [D
floats [F
bools [Z
shorts [S
longs [J
bytes [B
 * 
 * @author Dhruv.Rathore
 *
 */
public class PrimitiveToClassConverter {
	
	public static Number convertToClass(String value, String type){
		if(type.equals("int") || type.equals("java.lang.Integer"))
			return Integer.valueOf(value);
		else if(type.equals("byte") || type.equals("java.lang.Byte"))
			return Byte.valueOf(value);
		else if(type.equals("short") || type.equals("java.lang.Short"))
			return Short.valueOf(value);
		else if(type.equals("long")|| type.equals("java.lang.Long") )
			return Long.valueOf(value);
		else if(type.equals("float") || type.equals("java.lang.Float"))
			return Float.valueOf(value);
		else if(type.equals("double") || type.equals("java.lang.Double"))
			return Double.valueOf(value);
		return null;
	}

}
