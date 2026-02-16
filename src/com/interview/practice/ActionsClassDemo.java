package com.interview.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")) != null) 
			{driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();}
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
		WebElement amazonSearchBox = driver.findElement(By.xpath("//*[@placeholder='Search Amazon']"));
		
		action.moveToElement(amazonSearchBox)
											.click().keyDown(Keys.SHIFT)
											.sendKeys("hello").build().perform();
		action.moveToElement(amazonSearchBox)
											.click().keyDown(Keys.SHIFT)
											.sendKeys("hello").doubleClick().build().perform();
		Thread.sleep(2000);
		// move to element
		action.moveToElement(move).build().perform();
		Thread.sleep(2000);
		// right click
		action.moveToElement(move).contextClick().build().perform();
		Thread.sleep(2000);
		
	}

}
