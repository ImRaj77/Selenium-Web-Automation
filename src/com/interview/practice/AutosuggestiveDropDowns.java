package com.interview.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;

public class AutosuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// CheckBox
		WebElement srCitixenChkBx = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		
		Assert.assertFalse(srCitixenChkBx.isSelected());
		
		srCitixenChkBx.click();
		
		Assert.assertTrue(srCitixenChkBx.isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		// Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
	 	List<WebElement>  options = driver.findElements(By.xpath("//*[@class='ui-menu-item']/a"));
	 	
	 	for(WebElement option : options) {
	 		if(option.getText().equalsIgnoreCase("India")) {
	 			option.click();
	 			break;
	 		}
	 	}
	 	Thread.sleep(2000);
	 	driver.quit();
	}
}
