package com.interview.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderPractice {

	public static void main(String[] args) throws InterruptedException {
		
		String date = "15";
		String monthNumber = "6";
		String year = "2027";
		String[] expected = {monthNumber, date, year};
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement elementDatePicker = driver.findElement(By.cssSelector("div.react-date-picker__inputGroup"));
		elementDatePicker.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		Thread.sleep(1000);
		driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month"))
			.get(Integer.parseInt(monthNumber)-1).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		Thread.sleep(1000);

		//System.out.println(elementDatePicker.getText());
		
		List<WebElement> list = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i=0; i<list.size(); i++) {
			//System.out.println(list.get(i).getAttribute("value"));
			Assert.assertEquals(list.get(i).getAttribute("value"), expected[i], "Expected is not matching with Actual");
		}
	}

}
