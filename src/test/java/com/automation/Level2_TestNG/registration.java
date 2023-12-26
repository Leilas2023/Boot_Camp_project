package com.automation.Level2_TestNG;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class registration {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
	    driver = new ChromeDriver();
	    driver.get("https://accounts.google.com/signup");
	    }
	@Test
	public void testingRegistration(String firstName, String lastName, 
			String userName, String password, CharSequence[] phoneNumber) {
		driver.manage().window().maximize();
		
        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);

        WebElement nextButton = driver.findElement(By.linkText("Next"));
        nextButton.click();
        
        WebElement userNameField = driver.findElement(By.name("Username"));
        userNameField.sendKeys(userName);
        
        nextButton.click();
        
        WebElement createPasswordField = driver.findElement(By.id("passwd"));
        createPasswordField.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.name("PasswdAgain"));
        confirmPassword.sendKeys(password);
        
        WebElement phoneNumberField = driver.findElement(By.id("phoneNumberId"));
        phoneNumberField.sendKeys(phoneNumber);
        
        nextButton.click();
        
        WebElement successMessage = driver.findElement(By.id("success-message"));
        Assert.assertEquals(successMessage, "You're registered successfully, Please verify your account from gmail", 
        		"Registration was not successful.");
    }		
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}