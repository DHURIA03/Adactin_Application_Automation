package com.shoppingcart.pages;

import org.openqa.selenium.By;

import com.shoppingcart.utilities.BaseClass;

public class orderConfirmationPage extends BaseClass

{
	//Objects
	static By confirmText = By.cssSelector(".hero-primary");
	
	//Actions
	public String getConfirmationMessage() 
	{
		String finalMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return finalMessage;
		
	}

}
