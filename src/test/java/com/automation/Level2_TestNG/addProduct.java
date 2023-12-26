package com.automation.Level2_TestNG;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class addProduct {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
	    driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
	    }
	@Test
	public void testingAddProduct(String product) {
		driver.manage().window().maximize();
		
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(product);
        searchBox.submit();

        WebElement firstSearchResult = driver.findElement(By.cssSelector(".s-result-item h2 a"));
        firstSearchResult.click();
        
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement cartIcon = driver.findElement(By.id("nav-cart"));
        cartIcon.click();
        
        WebElement cartProductTitle = driver.findElement(By.cssSelector(".sc-product-title"));
        String actualProductName = cartProductTitle.getText();
        String expectedProductName = product; 
        
        Assert.assertEquals(actualProductName, expectedProductName, "Incorrect product in the cart.");

    }		
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}