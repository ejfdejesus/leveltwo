package com.clarence.pageobjects;

import org.openqa.selenium.WebDriver;

import com.clarence.common.BasePageObject;

public class LinkedInLogin extends BasePageObject{

	public LinkedInLogin(WebDriver driver) 
	{
		super(driver);
	}
	
	public void login(String username, String password)
	{
		type(username, "login-email");
		type(password, "login-password");
		click("login-submit");
	}

}
