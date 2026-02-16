package com.interview.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, dest).build().perform();
		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		// you are out from frame now
		

	}

}
