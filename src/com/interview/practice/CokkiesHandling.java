package com.interview.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CokkiesHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("");
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("abcd");
		
		driver.manage().addCookie(null);
		driver.manage().deleteCookie(null);
		
		// Session cokkie delete and secure login should logout and do login again
		driver.manage().deleteCookieNamed("sessionKey");
		// and then do login on the application
		
	}

}
