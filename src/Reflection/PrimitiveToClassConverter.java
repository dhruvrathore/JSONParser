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
		if(type.equals("int"))
			return Integer.valueOf(value);
		else if(type.equals("byte"))
			return Byte.valueOf(value);
		else if(type.equals("short"))
			return Short.valueOf(value);
		else if(type.equals("long"))
			return Long.valueOf(value);
		else if(type.equals("float"))
			return Float.valueOf(value);
		else if(type.equals("double"))
			return Double.valueOf(value);
		return null;
	}

}
