package com.ado.testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

public class janrelease extends CommonTest {

	public janrelease() throws IOException {
		super();
		//driver=BaseTest.getDriver();
		
		// TODO Auto-generated constructor stub
	
	}
	 
	 @Parameters({ "startRow", "endRow" })
	 @Test
	public void adminlogin(String StartRow, String Endrow) {
		
		int startRow=Integer.parseInt(StartRow);
		int endRow = Integer.parseInt(Endrow);
		String UserName=xl.getCellData("Testdata", "Username", endRow);
		String PassWord=xl.getCellData("Testdata", "Password", endRow);
		String url=xl.getCellData("Testdata", "URL", endRow);
		System.out.println(UserName);
		System.out.println(PassWord);
		System.out.println(url);
		login(logger,UserName, PassWord,url);
		util.pause(logger, 2);
		//getDriver();
		System.out.println("Success in Jan Realese"+driver.getClass().toString());
		 String user=driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).getText();
		 System.out.println(user);
	}
	 
	 @Test
	 public void validatemyifo() {
		
		 WebElement myinfo=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span"));
		 myinfo.click();
		 util.pause(logger, 2);
		 String pdetails=driver.findElement(By.cssSelector(" .orangehrm-tabs-item.--active")).getText();
		
		 System.out.println(pdetails);
		
	}
		 
		 
		 
	 
	 
			
	
	

}
