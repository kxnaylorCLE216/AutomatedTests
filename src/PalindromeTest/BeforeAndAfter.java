package PalindromeTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigReader;

public class BeforeAndAfter {
	
	 static WebDriver driver;
	 static pages.LoginPage loginPage;
	 static pages.PalindromeTestPage palindromeTestPage;

	@BeforeClass
	  public static void setUp(){
		
		ConfigReader reader = new ConfigReader();
					
		String strURL = reader.getURL();
		
		String strBrowserType = reader.getBrowserType();
		
		String strDriverPath = reader.getDriverPath();
				
		System.setProperty(strBrowserType, strDriverPath);
		
		driver = new ChromeDriver();    
		
		driver.navigate().to(strURL);
		
		loginPage = new pages.LoginPage(driver);
		
		palindromeTestPage = new pages.PalindromeTestPage(driver);
			
	}
	
	@AfterClass
	 public static void tearDown(){
		
		driver.close();
	
	}
}
