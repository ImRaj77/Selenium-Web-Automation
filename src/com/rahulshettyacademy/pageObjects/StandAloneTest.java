package com.rahulshettyacademy.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("rajtidke77@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Udemy@77");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card")));
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.cssSelector(".card"));
		Thread.sleep(2000);
		WebElement prod = products.stream().filter(product-> 
						  product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
						  .findFirst().orElse(null);
		Thread.sleep(2000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".form-group button span")));

		List<WebElement> countries = driver.findElements(By.cssSelector(".form-group button span"));
		WebElement countr = countries.stream().filter(country-> country.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		countr.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmOrderMessage =  driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmOrderMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		Thread.sleep(3000);
		driver.close();
	}
}
