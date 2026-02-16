package com.selenium4.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement nameEditBox =  driver.findElement(By.xpath("//input[@name='name']"));
		String nameText = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		
		System.out.println(nameText);
		
		Thread.sleep(2000);
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		WebElement belowText = driver.findElement(with(By.tagName("input")).below(dob));
		belowText.click();
		System.out.println(belowText.getAttribute("value"));
		
		Thread.sleep(1000);
		WebElement checkMeOut = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkMeOut)).click();
		
		Thread.sleep(1000);
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		Thread.sleep(2000);
		driver.close();
	}

}
