package com.interview.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
public class AmazonInterview {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		// Have an expected array
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Potato"};
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0; i< products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			
			String formattedName = name[0].trim();
			
			// Check whether name extracted is present in array or not
			// Convert array to Arraylist
			
			List veggies = Arrays.asList(itemsNeeded);
			if(veggies.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==4) {
					break;
				}
			}
		}
	}
}