package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of the WebPage is : " + title);
	}

	@Test
	public void login() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement userName = driver.findElement(By.name("userName")); 

		userName.sendKeys("admin");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");

		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();

		Thread.sleep(4000);
		
		String welcomeText = driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).getText();
		
		System.out.println("Text is : " + welcomeText);		
			
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();		
	}
	
	/*
	 * Framework in Selenium
	 * 
	 * Page Object Model Design:
	 * 
	 * This a design Pattern, Object Repository for Web UI Elements
	 * 
	 * Duplication of code,
	 * Less Time
	 * 
	 * 
	 * 
	 * 
	 */
}
