package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fisinput= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//config//config.properties");
			prop.load(fisinput);			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
			driver= new ChromeDriver();			
		}
		else
		if(browserName.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//resources//geckodriver.exe");
			driver= new FirefoxDriver();				
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver= e_driver;
		
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//System.out.println("Before pageloadtimeout");
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Before URL Entered");
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		//driver.navigate().to(prop.getProperty("url"));
		System.out.println("URL Entered");
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.titleIs("#1 Free CRM for Any Business: Online Customer Relationship Software"));
		System.out.println("Waited for sufficient time");
		
	}
	
}
