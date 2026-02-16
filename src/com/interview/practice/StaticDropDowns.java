package com.interview.practice;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		// Dropdown with Select tag
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement currencyStaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(currencyStaticDropdown);
		
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
				
		Thread.sleep(3000);
		driver.quit();
	}

}
