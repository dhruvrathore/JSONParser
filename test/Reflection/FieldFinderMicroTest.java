package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import test.entity.MockClass;


public class FieldFinderMicroTest {
	
	@Test
	public void testgetAllFieldsForClass(){
		FieldFinder fieldFinder = new FieldFinder();
		fieldFinder.getAllFieldsForClass(MockClass.class);
	}
	@Test
	public void testNullForInt(){
		// null entry for numeric type is not allowed
	}
	@Test
	public void testNullForInteger(){
		// null is valid for Integer as integer is an object rather than primitive datatype
	}
}
