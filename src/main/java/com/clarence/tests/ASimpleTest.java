package com.clarence.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarence.common.Fixture;
import com.clarence.pageobjects.SearchPage;

public class ASimpleTest extends Fixture {

	@Test
	public void FirstTest() throws IOException 
	{
		SearchPage search = new SearchPage(driver);
		search.inputSearchAndSubmit("Hannah Montana");
		takeScreenshot("SearchHannah");
		
		Assert.assertEquals(search.returnSearchResults(), 9, "Wrong number of search results displayed!" );
	}
}
