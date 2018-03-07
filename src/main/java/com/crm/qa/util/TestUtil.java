package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.naming.directory.InvalidSearchFilterException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEETPATH="C://Users//keerv//Desktop//Catalog Tool//FreeCRMTest//src//main//java//com//crm//qa//testdata//CRM_TestData.xlsx";
	
	public void switchToFrame(String frameName)
	{
		System.out.println("Am in Switch to frame");
		driver.switchTo().frame(frameName);
		System.out.println("Switched to frame successfully");
	}
	
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream file=null;
		Workbook book=null;
		Sheet sheet=null;
		try
		{file = new FileInputStream(TESTDATA_SHEETPATH);}
		catch(IOException e)
		{e.printStackTrace();}		
		
		try
		{book = WorkbookFactory.create(file);}
		catch(InvalidFormatException e)
		{e.printStackTrace();}
		catch(IOException ie)
		{ie.printStackTrace();}
		
		sheet = book.getSheet(SheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k< sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}		
		return data;		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		String currentDir = System.getProperty("user.dir");
		TakesScreenshot t = (TakesScreenshot)driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile , new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}

}
