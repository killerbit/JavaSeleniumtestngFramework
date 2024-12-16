package com.ado.testCase;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ado.pages.BasePage;
import com.ado.util.BrowserHelper;
import com.ado.util.FrameHelper;
import com.ado.util.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import xls.xls_reader;

public class CommonTest extends BaseTest {
	
	  WebDriver driver;
	public Utility util;
	public FrameHelper frameHelper;
	public BrowserHelper browserHelper;
//	public xls_reader xl;
	public String testsheetName;
	public BasePage basep;
	
	
	public CommonTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		util=new Utility();
		//driver=BaseTest.driver;
		browserHelper=new BrowserHelper();
	//	basep = new BasePage(driver);
		
		
	}
	
	
	@BeforeSuite
	public void getSuitName(ITestContext context) {
		// Retrieve the suite name from the context
		String suiteName = context.getSuite().getName();
		// Print the suite name
		System.out.println("Suite Name: " + suiteName);
	}

	@Parameters({ "inputsheetname" })
	@BeforeTest
	public void setInputSheetName(String testsheetName) {
		getInputSheetName(testsheetName);
		System.out.println("@@@@@@@Test sheet name set to: " + testsheetName);
	}

	

	@Parameters({"testcaseName"})
	@BeforeTest
		 public void setUp(String testcaseName, ITestContext context) {
			getInputDataFromExcel(testcaseName);
			
			
	}

	@AfterMethod
	public void flush() {
		//extent.flush();
		System.out.println("I am Into After Method");
		//driver.quit();
	}
	
	
	//Initialize
	
	
	 public void InitializePage() {
		
		// basep = PageFactory.initElements(driver,BasePage.class);
		// String userDirectoryPath = System.getProperty("user.dir");
		 driver=getDriver();
		System.out.println("Initi all web Elements");
			
			
	}
	
	
	//Fetch Data
	public String getInputData(String rowName, String colName) {

	String data="";

	try {
			data=inputData.get(rowName).get(colName).toString();
		}

	catch (NullPointerException e)
		{

		e.printStackTrace();

		System.out.println("Data is null. Either Row name or column name is absent in test data sheet.");
		}
	catch(Exception e) 
		{

				e.printStackTrace();
		}

	return data;

	
	}
	
	//Login Into Application
	@Test
	public void login(ExtentTest logger,String UserName, String PassWord,String url) 
	{
		//try {
			
			
			
			//InitializePage();
			
			//choosing account to login
			
			navigate(logger,url);
			util.pause(logger, 2);
			
			
			InitializePage();
			String temp =driver.getClass().toString();
			System.out.println("driver in CoomonTest classs"+temp);
			WebElement Username1= driver.findElement(By.xpath("//input[@name='username']"));
			//WebElement Username1 =BasePage.text(driver);
			Username1.sendKeys(UserName);
			util.pause(logger, 5);
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			password.sendKeys(PassWord);
			util.pause(logger, 5);
			//button[@type='submit']
			WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton.click();
			util.pause(logger, 5);

			
			
	//	}
	//	catch(Exception e)
		
	//	{
			//System.out.println("Error");
	//		
	//	}
		
		
	}

	
	
	

}
