package entity;

public class StringJSONElement implements JSONElement {
	private String jsonString;
	
	public StringJSONElement(String str){
		this.jsonString = str;
	}

	@Override
	public Object getValue() {
		return jsonString;
	}
	
}
