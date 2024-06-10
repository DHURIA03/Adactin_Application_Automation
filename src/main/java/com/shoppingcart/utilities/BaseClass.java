package com.shoppingcart.utilities;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
public static WebDriver driver ;


	public static void openApplication() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.rahulshettyacademy.com/client");
		
	}
	
	public static void closeApplication() 
	{
		driver.close();
	}
	
	public static void waitForElement(By webelementWait) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(webelementWait));
	}
	
	public static void takeScreenshot(String Name) throws Exception 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\Ashish\\Desktop\\Python\\"+ Name));
	}

}
