package com.shoppingcart.pages;

import org.openqa.selenium.By;

import com.shoppingcart.utilities.BaseClass;

public class header extends BaseClass
{
	//Objects
	static By cartBtn = By.cssSelector("[routerlink='/dashboard/cart']");
	
	//Actions
	public void clickOnCartButton() 
	{
		driver.findElement(cartBtn).click();
	}

}
