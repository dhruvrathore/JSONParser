package entity;

public class NumericJSONElement implements JSONElement {

	private Object number;
	public NumericJSONElement(Object number){
		this.number = number;
	}
	@Override
	public Object getValue() {
		return number;
	}


}
