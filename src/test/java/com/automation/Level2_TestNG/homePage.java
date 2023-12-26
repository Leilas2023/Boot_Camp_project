package com.automation.Level2_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class homePage {
	public WebDriver driver;
	
	@Test
	public void testingHomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
        WebElement musicButton = driver.findElement(By.id("music")); 
        Assert.assertTrue(musicButton.isDisplayed(), "Music button is not displayed on the home page.");

        WebElement SigninLink = driver.findElement(By.linkText("Sign in"));
        SigninLink.click();
    }		
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}