package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest  extends TestBase
{	
	Loginpage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new Loginpage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		System.out.println("Entered priority1 test");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void validateCRMLogoTest()
	{
		boolean flag= loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();	
		
	}
	
	
	
	
	
	
	
	
	
	

}
