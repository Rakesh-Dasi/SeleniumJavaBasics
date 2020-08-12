package com.selenium;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.Constant;
import com.utility.ExcelUtils;

public class FileUploadTest {

	
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
	
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("frmAddEmp")));
		Thread.sleep(2000);
		dashboardPage.click_ChooseFileButton();
		Thread.sleep(2000);
		
		//Specify the file Location
		StringSelection sel = new StringSelection("Files/TestFile.docx");
		
		//
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		//Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}

	
}
