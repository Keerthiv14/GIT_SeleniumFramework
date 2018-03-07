package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new Loginpage();
		testUtil = new TestUtil();		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}	
	
	
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest()
	{		
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page Title is not matched");
	}
	
	@Test(priority=2)
	public void VerifyUserNameIsDisplayed() throws InterruptedException
	{
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyHomePageUserName());		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();	
		
	}
}
