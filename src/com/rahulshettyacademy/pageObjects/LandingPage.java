package com.rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="userPassword")
	private WebElement passwordField;
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}
