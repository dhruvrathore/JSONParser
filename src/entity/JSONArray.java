package entity;

import java.util.ArrayList;
import java.util.List;

public class JSONArray implements JSONElement {

	private List<JSONElement> objectArray;
	
	public JSONArray(){
		objectArray = new ArrayList<>();
	}
	
	
	public void add(JSONElement toAdd){
		objectArray.add(toAdd);
	}
	
	@Override
	public Object getValue() {
		List<Object> convertedList = new ArrayList<>();
		for(JSONElement jsonElement : objectArray){
			convertedList.add(jsonElement.getValue());
		}
		return convertedList;
	}


}
