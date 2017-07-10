package com.clarence.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarence.common.Fixture;
import com.clarence.pageobjects.LinkedInHome;
import com.clarence.pageobjects.LinkedInLogin;
import com.clarence.pageobjects.LinkedInProfile;
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
	public void LinkedInTest()
	{
		try 
		{
			LinkedInLogin login = new LinkedInLogin(driver);
			login.login("clarenciotan@gmail.com", "deadPoolHottie19");
			
			LinkedInHome home = new LinkedInHome(driver);
			home.GoToMyProfile();
			
			LinkedInProfile profile = new LinkedInProfile(driver);
			Assert.assertEquals(profile.getProfileName(), "Clarencia Tan");
			Assert.assertEquals(profile.getProfilePosition(), "Senior QA Engineer | QA Lead at Sitecore");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
