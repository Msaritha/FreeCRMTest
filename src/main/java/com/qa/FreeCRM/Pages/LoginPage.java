package com.qa.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRM.TestBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Intitalising Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un	,String pw) {
		userName.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
		
	}
	
}
