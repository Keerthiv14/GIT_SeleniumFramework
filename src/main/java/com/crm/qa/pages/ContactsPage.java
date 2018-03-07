package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//Declaration
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement VerifyContacts;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement TitleCbx;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement strFirstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement strLastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement strCompany;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit' ]")
	WebElement SaveBtn;
	
	
	
	//Initialization
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public boolean verifyContactspageIsDisplayed()
	{
		
		return VerifyContacts.isDisplayed();
	}
	
	public void clickContactsChk(String ValueToClick)
	{
		driver.findElement(By.xpath("//a[.='"+ValueToClick+"']/../../td[1]/input")).click();	
	}
	
	public void createNewContact(String title, String FirstName, String LastName, String Company)
	{
		
		Select select = new Select(TitleCbx);
		select.selectByValue(title);
		
		strFirstName.sendKeys(FirstName);
		strLastName.sendKeys(LastName);
		strCompany.sendKeys(Company);	
		SaveBtn.click();
		
		
	}
	
	
	

}
