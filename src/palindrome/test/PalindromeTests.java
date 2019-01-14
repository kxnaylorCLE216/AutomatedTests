package palindrome.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PalindromeTests extends BeforeAndAfter {
	
	Logger logger = Logger.getLogger(PalindromeTests.class.getName());
		
	@Before
	public void redirectedValidCred() {
		loginPage.loginIntoPage();
	}
		
	@Test
	public void dynamicPalindrome() {
			
	   List<String> firstList 
	   = palindromeTestPage.getAllPalindromes();

	   loginPage.backToLogin();
	   
	   loginPage.loginIntoPage();
		
	   List<String> secondList 
	   = palindromeTestPage.getAllPalindromes();
	   
	   boolean isDynamic = (!firstList.equals(secondList));
	   
	   assertTrue(isDynamic);
		
	}

	@Test
	public void buttonDisplaysMorePalindrome() {
		
		boolean isPalindrome 
		= palindromeTestPage.isMorePalindromesButton();
		
		assertTrue(isPalindrome);
		
	}
	
	@Test
	public void countPalindromeNum() {
		
		 List<String> palindromesList 
		   = palindromeTestPage.getAllPalindromes();
		 
		 List<String> lines = Arrays.asList("The count of the visible Palindromes", 
				 String.valueOf(palindromesList.size()));
		 
		 Path file = Paths.get("countPalindromeNum.txt");
		 
		 try {
			 
			Files.write(file, lines, Charset.forName("UTF-8"));
			
		} catch (IOException e) {
			
			String message = "Unable to write to countPalindromeNum.txt!";
			
			logger.log(Level.SEVERE, message, e);
   		
		}
	 		  
	}
	
}
