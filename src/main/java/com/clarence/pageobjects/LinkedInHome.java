package com.clarence.pageobjects;

import org.openqa.selenium.WebDriver;

import com.clarence.common.BasePageObject;

public class LinkedInHome extends BasePageObject {
	
	private String HomeLoc = "//span[contains(text(), 'My Network')]/../..//a";
	private String MyNetworkLink = "//span[contains(text(), 'My Network')]/../..//a";
	private String JobsLink = "//span[contains(text(), 'Jobs')]/../..//a";
	private String MessagingLink = "//span[contains(text(), 'Messaging')]/../..//a";
	private String NotificationsLink = "//span[contains(text(), 'Notifications')]/../..//a";
//	private String ProfileButton = "//span[contains(text(), 'Me')]/../../..//button";
	private String ProfileButton = "button span[class='nav-item__title nav-item__dropdown-trigger--title']";
			
	public LinkedInHome(WebDriver driver) 
	{
		super(driver);
	}
	
	public void GoToMyNetwork()
	{
		click(MyNetworkLink);
	}
	
	public void GoToMyProfile()
	{
		click(ProfileButton);
	}

}
