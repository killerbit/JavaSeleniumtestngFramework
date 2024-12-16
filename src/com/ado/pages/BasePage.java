package com.ado.pages;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ado.util.Utility;
import  com.ado.util.FrameHelper;
import  com.ado.util.BrowserHelper;




public class BasePage {

//properties file
	public WebDriver driver;
	Utility util;
	FrameHelper frameHelper;
	BrowserHelper browserHelper;
//data related
	public DateFormat dateFormat;

	public Date date;
	
	boolean status = false;
	public static WebElement element=null;
	
	//screenshot
	
	public String ScreenShotPath;
	public String ScreenShotFileName;
	//contructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		date = new Date();
		dateFormat=new SimpleDateFormat("ddMMyyy-HH_mm_ss");
		util = new Utility();
		frameHelper=new FrameHelper();
		browserHelper = new BrowserHelper();
		ScreenShotPath = System.getProperty("user.dir"+"\\ScreenShots\\");
		
	}
	
	
	/*public static WebElement text(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='username']"));
		
		return element;
		
		
	}*/

}
