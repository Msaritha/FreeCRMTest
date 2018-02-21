package com.qa.FreeCRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\sarit\\eclipse-workspace\\FreeCRMTest\\src\\"
					+"main\\java\\com\\qa\\FreeCRM\\Config\\Config.properties");
			prop.load(ip);
		}  catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Intialisation() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
			driver=new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
	}
}
