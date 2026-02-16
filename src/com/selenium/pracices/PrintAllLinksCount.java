package com.selenium.pracices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllLinksCount {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://qaclickacademy.com/practice.php");

		// Count of links on the entire page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Count of links in the footer section
		WebElement footerElement = driver.findElement(By.id("gf-BIG")); // limiting WD scope
		System.out.println(footerElement.findElements(By.tagName("a")).size());

		// Count of a specific section in the footer
		WebElement columnElement = footerElement.findElement(By.xpath("//div[@id='gf-BIG']//ul"));
		System.out.println(columnElement.findElements(By.tagName("a")).size());

		// click on each link in the first column and check each link is opened
		for (int i = 1; i < columnElement.findElements(By.tagName("a")).size(); i++) {
			// Keybord event pass through sendKeys()
			String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columnElement.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(3000);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
	}
}