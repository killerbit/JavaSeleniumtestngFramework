package com.ado.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {
	
	String reqiestID="";
	String screenShotPath="Reports\\Screenshots\\";
	public DateFormat dateFormat;
	public Date date;
	public Utility() {
		
		screenShotPath="Reports\\Screenshots\\";
		dateFormat = new SimpleDateFormat("ddMMyyy-HH_mm_ss");
		date = new Date();
	}
	
	 public void setText(ExtentTest logger, WebElement element, String text) {
	        try {
	            element.clear();
	            element.sendKeys(text);
	            logger.log(LogStatus.INFO, "Set text '" + text + "' in element: " + element.toString());
	        } catch (Exception e) {
	            logger.log(LogStatus.FAIL, "Failed to set text '" + text + "' in element: " + element.toString() + " - " + e.getMessage());
	        }
	    }
	 
	 
	 public void pause(ExtentTest logger, int text) {
	 
	 try {  
		 
		 
		   
		 // The main thread sleeps for the 1000 milliseconds, which is 1 sec  
		
		 Thread.sleep(text*1000);  
		 System.out.println("Loading....in "+text+".....seconds."); 
		
	//	 logger.log(LogStatus.INFO, "wait For'" + text + "' for element: ");
		   
		 }  
		 catch (Exception expn)   
		 {  
		 // catching the exception  
		 System.out.println(expn);  
		 }  
	 }

}
