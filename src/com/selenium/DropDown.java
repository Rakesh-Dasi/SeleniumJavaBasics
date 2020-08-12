package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.Constant;
import com.utility.ExcelUtils;

public class DropDown {
	

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of the WebPage is : " + title);
	}
	
	@BeforeTest
	public void getDataFromExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData);
	}

	@Test
	public void login() throws Exception {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		String userName = ExcelUtils.getCellData(1, Constant.Col_UserName);
		String password = ExcelUtils.getCellData(1, Constant.Col_Password);	
		loginPage.enter_UserName(userName);
		loginPage.enter_Password(password);
		loginPage.click_LoginButton();		
		Assert.assertEquals(dashboardPage.getAdminTex(), "Welcome Admin");	
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement");
		
		WebElement dropdown = driver.findElement(By.id("entitlements_leave_type"));
		
		Select select = new Select(dropdown);
		select.selectByValue("1");
		
		Thread.sleep(2000);
		
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	
}
