package com.selenium4.features;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
		
		driver.get("https://rahulshettyacademy.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'absolute')]")));
		driver.findElement(By.xpath("//button[contains(@class,'absolute')]")).click();
		
		WebElement firstCourseElement = driver.findElement(By.xpath("//span[@class='text-primary']"));
		
		String firstCourseText = firstCourseElement.getText();
		System.out.println(firstCourseText);
		Thread.sleep(2000);
		
		driver.switchTo().window(parent);
		
		WebElement nameEditBox =  driver.findElement(By.xpath("//input[@name='name']"));
		nameEditBox.sendKeys(firstCourseText);
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
