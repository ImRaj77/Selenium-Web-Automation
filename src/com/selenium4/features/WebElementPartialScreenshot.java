package com.selenium4.features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementPartialScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox =  driver.findElement(By.xpath("//input[@name='name']"));

		nameEditBox.sendKeys("The A1 course");
		Thread.sleep(2000);
		
		// WebElement screenshot
		File sourceFile = nameEditBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("logo.png"));
		
		// Height and width of the WebElement
		System.out.println(nameEditBox.getRect().getDimension().getHeight());
		System.out.println(nameEditBox.getRect().getDimension().getWidth());
		
	}

}
