package com.ado.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BrowserHelper   {
	
	

	public static WebDriver driver;
	ExtentTest logger;
	public List <WebDriver> driverList =new LinkedList<WebDriver>();
	
	public  WebDriver startBrowser(ExtentTest logger,String browserNAme) {
		
		try {
			
			if(browserNAme.equalsIgnoreCase("chrome")) {
				System.out.println("*************** Started******************");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Arrays.asList("disable popup-blocking"));
				options.addArguments("--remote-allow-originrs-*");
				options.setAcceptInsecureCerts(true);
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				options.getBrowserVersion();
				options.setExperimentalOption("detach", true);
				options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				options.setCapability(ChromeOptions.CAPABILITY,options);
				//WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts();
				driver.manage().window().maximize();
				//logger.log(LogStatus.PASS,"<b>Chrome </b> Browser is started");
				System.out.println(" Started Chrome browser");
			}
			return driver;
		}
		catch(Exception e){
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Failed to launch the browser due to <b style='color.RED'>"+ e.getClass()+"<b>"+e.getMessage()+"</b>");
		
			return null;
		}
		
	}

	public void navigate(ExtentTest logger, String url) {
		
		 try {
	           // logger.log(LogStatus.INFO, "Navigating to URL: " + url);
			 System.out.println(url);
	            driver.get(url);
	            
	           // logger.log(LogStatus.PASS, "Successfully navigated to URL: " + url);
	        } catch (Exception e) {
	           // logger.log(LogStatus.FAIL, "Failed to navigate to URL: " + url + " - " + e.getMessage());
	        }
		
		
		
	}

	
	
	
}
