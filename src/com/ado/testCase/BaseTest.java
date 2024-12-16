package com.ado.testCase;
import com.ado.util.BrowserHelper;
import com.ado.util.FrameHelper;
import com.ado.util.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import xls.xls_reader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseTest   {
	
	
	public static WebDriver driver;
	public Utility util;
	public FrameHelper frameHelper;
	public BrowserHelper browserHelper;
	public xls_reader xl;
	ExtentTest logger;
	//Variable for taking data from Excel
	

	public int startRow=1;

	public int endRow=2;

	//Variable for reports

	public static ExtentReports extent;

	public DateFormat dateFormat;

	public Date date;

	static String currentPath = "";

	static String suiteFolderPath = "";

	HSSFWorkbook newwork;

	HSSFSheet newsheet;

	FileOutputStream os1;

	String filepath, catalogname;

	File filename;

	HSSFRow rownew;

	HSSFCell celltest, celli, cellll, cell2, cell21;

	int tottc;
	public Map<String,Map<String, String >>inputData;

	//Constructor
	

	public BaseTest() throws IOException{

	date=new Date();

	dateFormat= new SimpleDateFormat("ddMMyyyy-HH_mm_ss");

	//Current Project Path

	currentPath = System.getProperty("user.dir");

	//Creating Map object for storing the Excel data

	inputData =new HashMap<String, Map<String, String>>();

	//Creating Object for X1s_Reader\

	//x1= new X1s_Reader(System.getProperty("user.dir")+"//Input.xlsx");

	browserHelper =new BrowserHelper();

	util =new Utility();

	frameHelper =new FrameHelper();

	

	}
	

	//Fetch data from excel

	public void getInputDataFromExcel (String testcaseName) {

	System.out.println("------------------------------This is "+testcaseName+" Data Info-----------------------------");

	int rowCount = xl.getRowCount("Testdata");

	int colCount = xl.getColumnCount("Testdata");

	System.out.println("rowcount :"+rowCount+" colCount	:"+colCount);

	for(int r=0;r<=rowCount; r++)
	{
	if(xl.getCellData("Testdata", 0, r).toString().equals(testcaseName))

	{

	startRow =r + 1;

	System.out.println("StartRow: "+startRow);

	break;

	}
	}

	for(int e=startRow;e<=rowCount;e++)
	{
		if(xl.getCellData("Testdata", e, e).toString().equalsIgnoreCase("End"))

		{

		endRow=e-1; 
		System.out.println("EndRow: "+endRow);
		break;

		}

		} 
		Map<String, String> testCaseValues;

		for(int row =startRow; row< endRow; row++)

		{

		testCaseValues = new HashMap<String, String>();

		for(int colValue = 0; colValue <colCount; colValue++)

		{

		if(!(xl.getCellData("Testdata", colValue, row).isEmpty()))
		{

		testCaseValues.put(xl.getCellData ("Testdata", colValue, 1), xl.getCellData("Testdata", colValue, row));

		}
		inputData.put(xl.getCellData("Testdata", 0, row), testCaseValues);

		}

		}
		
		System.out.println("Getting input data from "+ "Testdata"+" sheet is SUCCESS");

		System.out.println();
		printMap(testcaseName);
		
		
	}
	
	//get sheet name
	
	public void getInputSheetName(String inputsheet) {
		
		
		/*
		 * String filePath = testsheetName; // Path to your Excel file String sheetName
		 * = null;
		 * 
		 * try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook =
		 * new XSSFWorkbook(fis)) {
		 * 
		 * // Assume the mapping is in the first sheet Sheet sheet =
		 * workbook.getSheetAt(0);
		 * 
		 * // Iterate over the rows to find the test case name for (Row row : sheet) {
		 * if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testsheetName)) {
		 * sheetName = row.getCell(1).getStringCellValue(); break; } }
		 * 
		 * if (sheetName != null) { logger.log(LogStatus.PASS,
		 * "Found input sheet name: " + sheetName + " for test case: " + testsheetName);
		 * } else { logger.log(LogStatus.FAIL,
		 * "No input sheet name found for test case: " + testsheetName); }
		 * 
		 * } catch (IOException e) { logger.log(LogStatus.ERROR,
		 * "Error reading Excel file: " + e.getMessage()); }
		 * 
		 * return testsheetName;
		 */
		String userDirectoryPath = System.getProperty("user.dir");
		System.out.println(inputsheet);
		xl = new xls_reader(userDirectoryPath+"//"+inputsheet);
		

		//System.out.println("Current Directory = \"" + userDirectoryPath + "\"" );
		
	
	}
	
	
	
	
	//Open Browser

	public void navigate(ExtentTest logger, String url) {
	
			System.out.println("Opening Browser");
	//String brname=inputData.get("navigate").get("browser").toString();
	//System.out.println(brname);
		driver=browserHelper.startBrowser(logger, "chrome");
		browserHelper.navigate(logger,url);
		System.out.println("Entered the URL");
		util.pause(logger, 15);
		String temp =driver.getClass().toString();
		System.out.println("driver in BaseTest classs"+temp);
	}
	
	public static WebDriver getDriver() {
		
		String temp =driver.getClass().toString();
		System.out.println("driver in BaseTest classs"+temp);
		return driver;
	} 
	
	
	//This method for displaying inputData map values

	//@param testcaseName

	public void printMap(String testcaseName) 
	{

	System.out.println("************************************"+testcaseName +" test case INPUT DATA ***********************");

	for (Map.Entry entry : inputData.entrySet()) {

	System.out.println(entry.getKey()+", "+entry.getValue());

	System.out.println();

	}
	System.out.println("****************************************"+testcaseName +" test case INPUT DATA ***********************");

	}
	
	   
	    
	    
	}

