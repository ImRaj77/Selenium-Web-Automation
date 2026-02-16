package com.interview.practice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("enter-name")).sendKeys("Rahul");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("alertbtn")).click();
		
		driver.switchTo().alert();
		
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
