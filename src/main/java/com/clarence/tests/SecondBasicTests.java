package com.clarence.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondBasicTests {

	private String PrintMeSec()
	{
		return "Sample from PrintMe()";
	}
	
	@Test(groups = {"chika"})
	public void Checkz()
	{
		Assert.assertEquals(PrintMeSec(), "Sample from PrintMeSec()");
	}

}
