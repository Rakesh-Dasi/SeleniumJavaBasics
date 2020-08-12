package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utility.Wait;

public class DashboardPage extends BaseClass {	
	
	public DashboardPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(how = How.XPATH, using = "//a[@id='welcome']")
	WebElement adminText;	
	
	@FindBy(how = How.XPATH, using = "//input[@id='photofile']")
	WebElement chooseFileButton;
	
	@FindBy(how = How.XPATH, using = "//b[contains(text(),'PIM')]")
	WebElement pimTab;
	
	@FindBy(how = How.XPATH, using = "//input[@id='btnAdd']")
	WebElement addButton;	
	
	
	public String getAdminTex() {
		return adminText.getText();
	}
	
	public void click_ChooseFileButton() throws Exception {
//		Wait.waitForElementAndClick(pimTab);
//		Wait.waitForElementAndClick(addButton);
		Wait.waitForElementAndClick(chooseFileButton);		
	}	
	
}
