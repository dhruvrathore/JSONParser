package Reflection;

import org.junit.Assert;
import org.junit.Test;

public class PrimitiveToClassConverterMicroTest {

	@Test
	public void testconvertToClassForInt(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("30", "int"),30);
	}
	
	@Test
	public void testconvertToClassForShort(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("56", "short"),(short)56);
	}
	
	@Test
	public void testconvertToClassForByte(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("-2", "byte"),(byte)-2);
	}
	
	@Test
	public void testconvertToClassForLong(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("-22222", "long"),(long)-22222);
	}
	
	@Test
	public void testconvertToClassForFloat(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("30.45", "float"),30.45f);
	}
	
	@Test
	public void testconvertToClassFordouble(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("233.345", "double"),233.345);
	}
	
	@Test
	public void testconvertToClassForInteger(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("-45", "java.lang.Integer"),new Integer(-45));
	}
	
	@Test
	public void testconvertToClassForDouble(){
		Assert.assertEquals(PrimitiveToClassConverter.convertToClass("-434.44", "java.lang.Double"),new Double(-434.44));
	}
	
	@Test
	public void testconvertToClassForNull(){
		Assert.assertNull(PrimitiveToClassConverter.convertToClass("-22222", "anything"));
	}
}
