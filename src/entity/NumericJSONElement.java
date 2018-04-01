package entity;

public class NumericJSONElement implements JSONElement {

	private Number number;
	private String type;
	public NumericJSONElement(Number number,String type){
		this.number = number;
		this.type = type;
	}
	@Override
	public Object getValue() {
		if(type.equals("int"))
			return number.intValue();
		else if(type.equals("byte"))
			return number.byteValue();
		else if(type.equals("short"))
			return number.shortValue();
		else if(type.equals("long"))
			return number.longValue();
		else if(type.equals("float"))
			return number.floatValue();
		else if(type.equals("double"))
			return number.doubleValue();
		return null;
	}


}
