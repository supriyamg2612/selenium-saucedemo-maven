package com.supriya.saucedemo.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import com.supriya.saucedemo.login.LoginPage;

public class TestClass {
	
	WebDriver driver = null;
	
	@BeforeSuite
	public void configuration() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/?ref=hackernoon.com");
	}

	@Test
	public void testOne() {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication("standard_user", "secret_sauce");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
