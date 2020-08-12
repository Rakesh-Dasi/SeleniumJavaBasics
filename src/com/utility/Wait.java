package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BaseClass;

public class Wait extends BaseClass {

	public Wait(WebDriver driver) {
		super(driver);		
	}
	
	public static void waitForElementAndClick(WebElement element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			ExpectedCondition<Boolean> elementIsDisplayed = arg0 -> element.isDisplayed();
			wait.until(elementIsDisplayed);
			element.click();
		}catch(Exception e) {
			throw new Exception("Element with locator : " + element + "Was not displayed ", e);
		}
		
	}

}
