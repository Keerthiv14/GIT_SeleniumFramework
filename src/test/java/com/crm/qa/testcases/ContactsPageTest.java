package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;
import com.thoughtworks.selenium.webdriven.commands.GetConfirmation;

public class ContactsPageTest extends TestBase
{	
	Loginpage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String SheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		contactsPage= new ContactsPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageDisplayedTest()
	{		
		Assert.assertTrue(contactsPage.verifyContactspageIsDisplayed());
	}
	
	@Test(priority=2)
	public void clickContactsChkTest()
	{
		contactsPage.clickContactsChk("Aamy Aadams");
	}	
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = testUtil.getTestData(SheetName);
		return data;
		
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String FirstName, String Lastname, String Company)
	{
		homePage.clickonNewContactsLink();
		contactsPage.createNewContact(title, FirstName, Lastname, Company);		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();	
		
	}	

}
