package com.shoppingcart.pages;

import org.openqa.selenium.By;

import com.shoppingcart.utilities.BaseClass;

public class loginPage extends BaseClass
{
	//Objects
	static By userEmail    = By.xpath("//input[@id='userEmail']");
	static By userPassword = By.id("userPassword");
	static By SubmitBtn    = By.id("login");
	
	//Actions 
	public static void loginApplication(String Un, String Pw) 
	{
		driver.findElement(userEmail).sendKeys(Un);
		driver.findElement(userPassword).sendKeys(Pw);
		driver.findElement(SubmitBtn).click();
	}
	

}
