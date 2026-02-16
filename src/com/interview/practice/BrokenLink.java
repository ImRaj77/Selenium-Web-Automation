package com.interview.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> linkElements = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement ele : linkElements) {
			String link = ele.getAttribute("href");
			HttpURLConnection con = (HttpURLConnection)new URL(link).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int responseCode = con.getResponseCode();
			
			if(responseCode>400) {
				System.out.println("The link with text: "+ele.getText()+" : is broken with code: "+responseCode);
			}
			System.out.println(responseCode);
		}
	}

}
