package com.clarence.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarence.common.Fixture;
import com.clarence.pageobjects.LinkedInHome;
import com.clarence.pageobjects.LinkedInLogin;
import com.clarence.pageobjects.SearchPage;

public class ASimpleTest extends Fixture {

	@Test(enabled = false)
	public void FirstTest() throws IOException 
	{
		SearchPage search = new SearchPage(driver);
		search.inputSearchAndSubmit("Hannah Montana");
		takeScreenshot("SearchHannah");
		
		Assert.assertEquals(search.returnSearchResults(), 9, "Wrong number of search results displayed!" );
	}
	
	@Test(enabled = true)
	public void LinkedInTest() throws InterruptedException
	{
		LinkedInLogin login = new LinkedInLogin(driver);
		login.login("clarenciotan@gmail.com", "deadPoolHottie19");
		
		LinkedInHome home = new LinkedInHome(driver);
		home.GoToMyProfile();
		
		
		Thread.sleep(5000);
	}
}
