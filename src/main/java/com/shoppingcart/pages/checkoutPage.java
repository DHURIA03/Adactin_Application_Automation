package com.shoppingcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.shoppingcart.utilities.BaseClass;

public class checkoutPage extends BaseClass
{
	//objects
	static By selectCountry    = By.xpath("//input[@placeholder='Select Country']");
	static By dropdownIndiaBtn = By.cssSelector(".ta-item:last-of-type");
	static By PlaceOrderBtn    = By.cssSelector(".action__submit");
	
	//Actions
	public void selectCountry(String CountryName) 
	{
		Actions select = new Actions(driver);
		select.sendKeys(driver.findElement(selectCountry), CountryName).build().perform();
		waitForElement(dropdownIndiaBtn);
		driver.findElement(dropdownIndiaBtn).click();
		
	}
	
	public void PlaceOrder()
	{
		driver.findElement(PlaceOrderBtn).click(); 
	}

	

}
