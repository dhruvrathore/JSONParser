package entity;

import java.util.List;
import java.util.Map;

import Reflection.FieldFinder;

public class JSONObject implements JSONElement {

	private Object obj;
	private Class classHolder;
	private Map<String,ClassField> allClassFields;
	
	public JSONObject(Object obj,Class holder) {
		super();
		this.obj = obj;
		this.classHolder = holder;
		allClassFields = FieldFinder.getAllFieldsForClass(classHolder);
	}

	@Override
	public Object getValue() {
		return obj;
	}
	
	public Class getClassHolder(){
		return classHolder;
	}
	
	public ClassField getClassField(String fieldName){
		return allClassFields.get(fieldName);
	}


}
