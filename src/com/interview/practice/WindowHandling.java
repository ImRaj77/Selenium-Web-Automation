package com.interview.practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement blinking = driver.findElement(By.cssSelector("a.blinkingText"));
		blinking.click();
		
		Set<String> windows =  driver.getWindowHandles(); // [parent, child]
		Iterator<String> itr = windows.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
		Thread.sleep(4000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'absolute')]")));
		driver.findElement(By.xpath("//button[contains(@class,'absolute')]")).click();
		driver.switchTo().window(parent);
	}

}
