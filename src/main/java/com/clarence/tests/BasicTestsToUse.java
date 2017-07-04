package com.clarence.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestsToUse {

	private String PrintMe()
	{
		return "Sample from PrintMe()";
	}
	
	private String AnotherPrinter(String name)
	{
		return "Your name should be: "+ name;
	}
	
	@Test
	public void TestOne()
	{
		Assert.assertEquals("Sample from PrintMe()", PrintMe());
	}
	
	@Test
	public void TestTwo()
	{
		Assert.assertEquals("Your name should be: Bike", AnotherPrinter("Mike"));
	}

}
