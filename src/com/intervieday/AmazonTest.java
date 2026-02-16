package com.intervieday;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.google.com/");
			
			WebElement searchBox =  driver.findElement(By.xpath("//textarea[@title='Search']"));
			searchBox.click();
			
			searchBox.sendKeys("Amazon");
			WebElement withImage = driver.findElement(By.xpath("//div[contains(@style,'background-image:')]/following-sibling::div[1]"));
			
			withImage.click();
			Thread.sleep(15000);
			driver.findElement(By.xpath("//span[text()='Shop online at Amazon India']")).click();
			
			WebElement welcomeUser = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
			
			String expectedText = "Hello, sign in";
			
			Assert.assertEquals(welcomeUser.getText(), expectedText, "Hello User is not correct text");
			System.out.println("test End");
			
		} finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
