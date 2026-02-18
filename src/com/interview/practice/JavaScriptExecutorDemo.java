package com.interview.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0; i<values.size(); i++) {
			int amount = Integer.parseInt(values.get(i).getText());
			sum = sum + amount;
		}
		System.out.println(sum);
		String actualSum = driver.findElement(By.cssSelector("div.totalAmount")).getText();
		actualSum = actualSum.replaceAll("[^0-9]", "");
		System.out.println(actualSum);
		Assert.assertEquals(Integer.parseInt(actualSum), sum, "Actual and expected sum are not matching");
	}

}
