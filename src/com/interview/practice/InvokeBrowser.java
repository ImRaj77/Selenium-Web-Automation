package com.interview.practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InvokeBrowser {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "/Users/rajabhau.tidke/Selenium/Chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// FireFox Driver - geckodriver "webdriver.gecko.driver)
		// WebDriver driver = new FirefoxDriver();
		
		// Edge Driver - edge driver "webdriver.edge.driver"
		// WebDriver driver = EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl().equals("https://rahulshettyacademy.com/locatorspractice/"));
		//driver.close();     // close current window
		//driver.quit();		// close all the associated windows opened by Selenium
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
				
//		String text = driver.findElement(By.cssSelector("p.error")).getText();   // CSS Selector
//		System.out.println(text);
//		
//		driver.findElement(By.linkText("Forgot your password?")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abcd@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
//		Thread.sleep(2000);
//		System.out.println("Done!!");
		
		Thread.sleep(1000);
		String logInMsg = driver.findElement(By.tagName("p")).getText();
		System.out.println(logInMsg.equalsIgnoreCase("You are successfully logged in.")+" The msg: "+logInMsg);
		Assert.assertEquals(logInMsg, "You are successfully logged in.");
		Thread.sleep(1000);
		driver.quit();
	}
}
