package com.intervieday;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaBasedPopUp {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com");
		
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
	}

}
