package com.clarence.pageobjects;

import org.openqa.selenium.WebDriver;

import com.clarence.common.BasePageObject;

public class LinkedInProfile extends BasePageObject {

	private String ProfileName = "h1[class^='pv-top-card-section__name']";  
	private String ProfilePosition = "h2[class^='pv-top-card-section__headline']";
	public LinkedInProfile(WebDriver driver)
	{
		super(driver);
	}
	
	public String getProfileName()
	{
		return parseLocator(ProfileName).getText();
	}
	
	public String getProfilePosition()
	{
		return parseLocator(ProfilePosition).getText();
	}

}
