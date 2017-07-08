package com.clarence.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.sun.jna.Native.ffi_callback;

public class Fixture {
	/*
	 * This method will create capabilities on the selected browser. 1. setting
	 * browser name 2. enabling javascript
	 */
	protected WebDriver driver;
	protected byte[] screenshot;
	protected String chromeDriverPath = "C:\\dev\\chromedriver\\chromedriver.exe";
	protected String geckoDriver = "C:\\dev\\gecko\\geckodriver.exe";

	protected Capabilities createCapabilities(String browser) 
	{
		DesiredCapabilities capabilities;
		if (browser.equals("chrome"))
		{
			ChromeOptions chOptions = new ChromeOptions();
			chOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			// chOptions.addArguments("start-maximized");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, chOptions);
			return capabilities;
		}
		else if(browser.equals("firefox"))
		{
			capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability(FirefoxBinary, value);
			capabilities.setCapability("marionette", true);
			capabilities.setJavascriptEnabled(true);
			return capabilities;
		}

		capabilities = new DesiredCapabilities();

		// capabilities.setBrowserName(browser);
		capabilities.setJavascriptEnabled(true);

		return capabilities;
	}

	private void waitForPageLoading() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	protected void takeScreenshot(String filename) throws IOException 
	{
		waitForPageLoading();
		String path = System.getProperty("user.dir").replace("\\", "//").concat("//");
		File screenshotfile = new File(path + filename + ".png");

		// Take screenshot:
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		FileOutputStream outPut = new FileOutputStream(screenshotfile);
		try
		{
			outPut.write(screenshot);
		} 
		finally
		{
			outPut.close();
		}
	}

	@Parameters({ "browser" })
	@BeforeTest
	public void startTest(String browser) 
	{
		if (browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(createCapabilities(browser));
		} 
		else if (browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", geckoDriver);
			driver = new FirefoxDriver(createCapabilities(browser));
		}
		String URL = System.getProperty("URL");

		driver.get(URL);
	}

	@AfterTest
	public void endTest() throws InterruptedException, IOException 
	{
		Thread.sleep(1500);
		driver.quit();
	}
}
