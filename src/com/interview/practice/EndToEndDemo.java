package com.interview.practice;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class EndToEndDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.mobiscroll.com/select/country-picker");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("input#demo155-country-picker")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[placeholder=\"Search\"]")).sendKeys("India");
		Thread.sleep(2000);
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='md-country-picker-item']"));
		Thread.sleep(2000);
		for(WebElement country : countries) {
			if(country.getText().trim().equalsIgnoreCase("India")) {
				System.out.println(country.getText());
				break;
			}
		}
	}
}
