package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {	
	
	//Declaration of elements
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement UserNameTxt;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLnk;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLnk;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLnk;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContact;
	
	
	
	
	//Initializing elements
	public HomePage()
	{
		PageFactory.initElements(driver, this);		
	}
	
	//Actions	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyHomePageUserName() throws InterruptedException
	{		
		System.out.println("UserNametext displayed value=="+UserNameTxt.isDisplayed());
		return UserNameTxt.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink()
	{		
		ContactsLnk.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		DealsLnk.click();
		return new DealsPage();
	}
	
	public void clickonNewContactsLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLnk).build().perform();		
		NewContact.click();		
	}
	
	
}
