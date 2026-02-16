package com.interview.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// Parent - child Relation
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[@value='MAA']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
