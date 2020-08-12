package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		/*
		 * Browser Elements
		 * 
		 * 1. Text boxes
		 * 2. Buttons
		 * 3. Images
		 * 4. HyperLinks
		 * 5.Radio button/Check Boxes
		 * Text area
		 * Drop down
		 * Web Tables
		 * Frames
		 * 
		 * Locating Browser Elements present on the web page
		 * 
		 * ID, Name, className, tagName, LinkText, CSS, XPATH
		 * 
		 */
		
	}

}
