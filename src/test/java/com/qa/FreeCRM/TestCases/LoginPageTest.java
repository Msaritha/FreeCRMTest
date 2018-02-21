package com.qa.FreeCRM.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.*;

import com.qa.FreeCRM.TestBase.*;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Intialisation();
		loginPage = new LoginPage();		
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	 
}
