package com.interview.practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		
		Thread.sleep(2000);
		driver.quit();
	}
}
