package com.interview.practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "/Users/rajabhau.tidke/Selenium/Chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("abc@gmail.com");
//		driver.findElement(By.name("inputPassword")).sendKeys("password");
//		driver.findElement(By.className("signInBtn")).click();
//		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//		
//		driver.findElement(By.linkText("Forgot your password?")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abcd@gmail.com");
//		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
//		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abcd@hotmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9876543210");
//		driver.findElement(By.xpath("//form/input[3]")).clear();
//		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
//		Thread.sleep(3000);
//		driver.quit();
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
	}
}
