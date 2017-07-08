package com.clarence.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTestsToUse {

	@DataProvider(name = "test1")
	public Object[][] createData1() {
		return new Object[][]{
			{"Cedric", new Integer(36), "Cedric 36"},
			{"Anne", new Integer(37), "Anne 37"}
		};
	}
	
	private String PrintMe()
	{
		return "Sample from PrintMe()";
	}
	
	private String AnotherPrinter(String name)
	{
		return "Your name should be: "+ name;
	}
	
	@Test(groups = {"chika"})
	public void TestOne()
	{
		Assert.assertEquals("Sample from PrintMe()", PrintMe());
	}
	
	@Test
	public void TestTwo()
	{
		Assert.assertEquals("Your name should be: Mike", AnotherPrinter("Mike"));
	}
	
	@Test(groups = {"dataprov"},dataProvider = "test1")
	public void TestThree(String name, int age, String expected)
	{
		Assert.assertEquals(name + " " + age, expected);
	}

}
