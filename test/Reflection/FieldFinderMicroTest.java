package Reflection;

import java.util.Map;

import org.junit.Test;

import entity.ClassField;
import org.junit.Assert;


class StubField{
	private int intField;
	private String stringField;
}

public class FieldFinderMicroTest {
	
	@Test
	public void testgetAllFieldsForClass(){
		Map<String,ClassField> allClassFields = FieldFinder.getAllFieldsForClass(StubField.class);
		Assert.assertTrue(allClassFields.size()==2);
		Assert.assertTrue(allClassFields.containsKey("intField"));
		Assert.assertTrue(allClassFields.containsKey("stringField"));
		
	}

}
