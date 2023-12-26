package com.automation.Level3_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class validateElement {
	public WebDriver driver;
	
	@Test
	public void testingValidateElement() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
        WebElement linkClimate = driver.findElement(By.linkText("Our third decade of climate action: join us")); 
        linkClimate.click();

        WebElement pageContent = driver.findElement(By.id("content")); 
        Assert.assertTrue(pageContent.isDisplayed(), "Element not found on the new page");
    }		
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}