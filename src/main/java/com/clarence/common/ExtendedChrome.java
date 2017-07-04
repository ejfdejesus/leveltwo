package com.clarence.common;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;     // was solved with <artifactId>selenium-java</artifactId>
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver; // was solved with <artifactId>selenium-java</artifactId>
import org.openqa.selenium.remote.DriverCommand;

public class ExtendedChrome extends ChromeDriver
{
	public ExtendedChrome(Capabilities caps)
	{
		super(caps);
	}
	
}
