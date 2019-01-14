package palindrome.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import data.provider.ConfigReader;

public class BeforeAndAfter {
	
	 static WebDriver driver;
	 static pages.LoginPage loginPage;
	 static pages.PalindromeTestPage palindromeTestPage;
	 static test.utility.CommonLib common;
	 static String headless = null;
	 static	ConfigReader reader = new ConfigReader();
	 	 
	@BeforeClass
	public static void setUp(){
						
		String strURL = reader.getURL();
		
		String strBrowserType = reader.getBrowserType();
		
		String strIsHeadLess = reader.getIsHeadLess();
		
		String strDriverPath = reader.getDriverPath();
				
		System.setProperty(strBrowserType, strDriverPath);
			
		System.setProperty("headless", strIsHeadLess);
					        
        if (strBrowserType.contains("chrome")) {
        	startChromeDriver();
        }
        else {
        	startFireFoxDriver();
        }
        
        	
                	
		driver.navigate().to(strURL);
		
		loginPage = new pages.LoginPage(driver);
		
		palindromeTestPage = new pages.PalindromeTestPage(driver);
			
	}
	
	@AfterClass
	public static void tearDown(){
		
		 if(null != driver) {
	            driver.close();
	          
	        }
	
	}
	
	private static void startChromeDriver() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		headless = System.getProperty("headless");
		
		if(headless.equals("true")) {
            chromeOptions.addArguments("--headless");
        } else {
        	chromeOptions.addArguments("--disable-infobars");
        } 
		
		driver = new ChromeDriver(chromeOptions);
	}
	
	private static void startFireFoxDriver() {
		
		FirefoxOptions ffOptions = new FirefoxOptions();
		   
		headless = System.getProperty("headless");
		
		if(headless.equals("true")) {
            ffOptions.addArguments("--headless");
        } else {
        	ffOptions.addArguments("--disable-infobars");
        } 
		
        driver = new FirefoxDriver(ffOptions);
	}
}
