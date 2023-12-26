package com.automation.Level1_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class login {
	public WebDriver driver;

	
	@Test
	public void testingLogin(String username, String password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();

        WebElement usernameField = driver.findElement(By.name("identifier"));
        usernameField.sendKeys(username);

        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();

        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys(password);

        WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
        passwordNextButton.click();

        WebElement profileIcon = driver.findElement(By.id("gb"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login unsuccessful");
    }		
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}