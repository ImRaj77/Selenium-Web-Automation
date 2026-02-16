package com.interview.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement passengersList = driver.findElement(By.id("divpaxinfo"));
		passengersList.click();
		
		Thread.sleep(1000);
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(1000);
			i++;
		}
			
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(passengersList.getText().contains(String.valueOf(i)));
		
		Thread.sleep(3000);
		driver.quit();

	}

}
