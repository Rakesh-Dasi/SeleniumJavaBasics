package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utility.Wait;

public class LoginPage extends BaseClass {	
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(how = How.ID, using = "txtUsername")
	WebElement usernameField;
	
	@FindBy(how = How.ID, using = "txtPassword")
	WebElement passwordField;
	
	@FindBy(how = How.ID, using = "btnLogin")
	WebElement loginButton;
	
	public void enter_UserName(String userName) {
		usernameField.sendKeys(userName);
	}
	
	public void enter_Password(String password) {
		passwordField.sendKeys(password);
	}
	
	public void click_LoginButton() throws Exception {
		Wait.waitForElementAndClick(loginButton);		
	}	

}
