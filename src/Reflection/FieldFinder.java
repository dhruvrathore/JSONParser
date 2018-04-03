package Reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.ClassField;

public class FieldFinder {

	public static Map<String,ClassField> getAllFieldsForClass(Class classToInspect){
		List<Field> fields = Arrays.asList(classToInspect.getDeclaredFields());
		Map<String,ClassField> fieldMap = new HashMap<>();
		fields.forEach((each)->{
			fieldMap.put(each.getName(),new ClassField(each.getName(), each) );
		});
		return fieldMap;
	}
	
}
