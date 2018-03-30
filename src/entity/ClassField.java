package entity;

import java.lang.reflect.Field;

public class ClassField {
	private String nameOfField;
	private Field field;
	
	public ClassField(String nameOfField, Field field) {
		super();
		this.nameOfField = nameOfField;
		this.field = field;
	}

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public Field getType() {
		return field;
	}

	public void setType(Field field) {
		this.field = field;
	}
	
	
	
	
}
