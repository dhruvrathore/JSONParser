package entity;

public class BooleanJSONElement implements JSONElement {

	private boolean boolJson;
	public BooleanJSONElement(boolean bool) {
		boolJson = bool;
	}
	@Override
	public Object getValue() {
		return boolJson;
	}

}
