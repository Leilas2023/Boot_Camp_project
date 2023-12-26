package com.automation.Level3_TestNG;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class navigate {
	public WebDriver driver;

	
	@Test
	public void testingNavigate() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google", "Page title is not as expected");
		
	}

@AfterMethod
public void tearDown() {
	driver.quit();
}

}
