package Utilities;

import org.junit.Assert;
import org.junit.Test;

public class UtilMicroTest {

	@Test
	public void capitalizeForValidString(){
		Assert.assertEquals(Util.capitalize("afilledstring"),"Afilledstring");
	}
	@Test
	public void capitalizeForEmptyString(){
		Assert.assertEquals(Util.capitalize(""),"");
	}
	@Test
	public void capitalizeForStringOfLength1(){
		Assert.assertEquals(Util.capitalize("b"),"B");
	}
}
