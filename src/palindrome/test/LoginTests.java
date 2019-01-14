package palindrome.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginTests extends BeforeAndAfter {
		
	@Test
	public void redirectedValidCred() {
				
		loginPage.loginIntoPage();
		
		boolean isRedirected = palindromeTestPage.isExpectedPageTitle();
				
		assertTrue(isRedirected);
	}
	
	@Test
	public void userNameRequired() {
				
		boolean boolRequired =loginPage.loginNoUserName();
				
		assertTrue(boolRequired);
	}
	
	@Test
	public void passwordRequired() {
				
		boolean boolRequired =loginPage.loginNoPassword();
		
		assertTrue(boolRequired);
	}
	
	@Test
	public void invalidUsernameCred() {
		
		loginPage.loginIntoPage("tester", "password");
		
		boolean isAlert = loginPage.isExpectedAlert();
				
		assertTrue(isAlert);
	}
	
	@Test
	public void invalidPasswordCred() {
		
		loginPage.loginIntoPage("test", "1234");
				
		boolean isAlert = loginPage.isExpectedAlert();
		
		assertTrue(isAlert);
	}

}
