package com.clarence.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	protected WebDriver driver;
	protected long defaultTimeout = 10L;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement findByName(String name) {
		return new WebDriverWait(driver, defaultTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}

	protected WebElement findByXPath(String xpath) {
		return new WebDriverWait(driver, defaultTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	protected WebElement findById(String id) {
		return new WebDriverWait(driver, defaultTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	protected WebElement findByCss(String css) {
		return new WebDriverWait(driver, defaultTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
	}

	private WebElement parseLocator(String locator) {
		WebElement theElem;
		if (locator.startsWith("//")) {
			theElem = findByXPath(locator);
		} else if (locator.startsWith("name[") || locator.startsWith("input[")) {
			theElem = findByCss(locator);
		} else if (locator.startsWith("q")) {
			theElem = findByName(locator);
		} else
			theElem = findById(locator);

		return theElem;
	}

	protected List<WebElement> multipleElements(String locator) {
		return new WebDriverWait(driver, defaultTimeout)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	protected void type(String text, String locator) {
		WebElement theElem = parseLocator(locator);
		theElem.sendKeys(text);
	}

	protected void typeAndSubmit(String text, String locator) {
		WebElement theElem = parseLocator(locator);
		theElem.sendKeys(text);
		theElem.sendKeys(Keys.RETURN);
	}

}
