package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import entity.MockClass;


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
	@Test
	public void explaratoryTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class mock = MockClass.class;
		MockClass obj = (MockClass) mock.newInstance();
		Method m = mock.getMethod("setName", String.class);
		m.invoke(obj,"str");
		System.out.println(m);
	}
	@Test
	public void exploratoryTestOnDynamicCasting() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object obj = new String("Str");
		System.out.println(Class.forName("java.lang.String").cast(obj));
		Class thisClass = this.getClass();
		Method m = thisClass.getMethod("setMethod", String.class);
		m.invoke(this, Class.forName("java.lang.String").cast(obj));
	}
	
	public void setMethod(String str){	
	}
}
