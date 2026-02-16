package com.intervieday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestDemo {

	public static void main(String[] args) throws InterruptedException {
		// Select the product which contains Shirt and add the same into cart and assert
		// that It has been added in the cart or not
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		Thread.sleep(5000);
		
		WebElement selectFilter = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		selectFilter.click();
		
		Select select = new Select(selectFilter);
		select.selectByValue("lohi");
		
		String finalProduct = "Sauce Labs Backpack";
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='inventory_item_name ']"));
		
		for (WebElement element : elements) {
			String productName = element.getText();
			if(productName.contains(finalProduct)) {
				WebElement addToCart = driver.findElement(By.xpath("//div[@class='inventory_item'][.//div[contains(text(),'"+finalProduct+"')]]//button[text()='Add to cart']"));
				addToCart.click();
			}
		}
		
		WebElement cartElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cartElement.click();
		
		WebElement addedElement = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		
		String actualText = addedElement.getText().toLowerCase();
		
		Assert.assertTrue(actualText.contains("sauce"), "Failed to match the added product in cart");
		Thread.sleep(5000);
		driver.close();
	}
}