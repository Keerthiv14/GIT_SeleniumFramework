package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase
{
	
	//Declaration of elements or object repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement SignUpBtn;

	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	
	//Initializing the page objects	
	public Loginpage()
	{
		System.out.println("Am in initialization of initelements");
		PageFactory.initElements(driver, this);
	}
	
	//Actions	
	public String  validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.sendKeys(Keys.ENTER);
		
		return new HomePage();
	}
	
	
	
	
	
	

}
