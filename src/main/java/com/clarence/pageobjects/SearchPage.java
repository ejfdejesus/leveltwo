package com.clarence.pageobjects;

import org.openqa.selenium.WebDriver;

import com.clarence.common.BasePageObject;

public class SearchPage extends BasePageObject
{
	private String searchLocator = "q";
	private String resultsLocator = "//div[contains(@class,'_NId')]/..//div[@class='g']";

	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void inputSearchAndSubmit(String searchString)
	{
		typeAndSubmit(searchString, searchLocator);
	}
	
	public int returnSearchResults()
	{
		return multipleElements(resultsLocator).size();
	}

}
