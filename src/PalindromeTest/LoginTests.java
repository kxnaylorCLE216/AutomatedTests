package PalindromeTest;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigReader;

public class LoginTests extends BeforeAndAfter {
	
	 static pages.LoginPage loginPage;
	 static pages.PalindromeTestPage palindromeTestPage;
	
	@Test
	public void RedirectedValidCred() {
				
		loginPage.loginIntoPage();
		
		boolean isRedirected = palindromeTestPage.isExpectedPageTitle();
				
		assertTrue(isRedirected);
	}
	
	@Test
	public void UserNameRequired() {
				
		boolean boolRequired =loginPage.loginNoUserName();
				
		assertTrue(boolRequired);
	}
	
	@Test
	public void PasswordRequired() {
				
		boolean boolRequired =loginPage.loginNoPassword();
		
		assertTrue(boolRequired);
	}
	
	@Test
	public void InvalidUsernameCred() {
		
		loginPage.loginWrongUserName("tester");
		
		boolean isAlert = loginPage.isExpectedAlert();
				
		assertTrue(isAlert);
	}
	
	@Test
	public void InvalidPasswordCred() {
		
		loginPage.loginWrongPassword("1234");
				
		boolean isAlert = loginPage.isExpectedAlert();
		
		assertTrue(isAlert);
	}
	

	

}
