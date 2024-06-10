package com.shoppingcart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.shoppingcart.utilities.BaseClass;

public class myCartPage extends BaseClass
{
	//Objects
	
	List<WebElement> cartElements = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	int count = 0;
	
	static By checkoutBtn = By.xpath("//li/button[@class='btn btn-primary']");
	
	//Actions
	public int validateNuberOfProductInCart() 
	{
		
		int count = cartElements.size();
		return count;
			
	}
	
	public void verifyProductDisplayInCart() 
	{
		for (WebElement cart :cartElements) 
		{
			System.out.println(cart.getText());
			
		} 
		
	}
	
	public void clickOnCheckout() 
	{
		driver.findElement(checkoutBtn).click();
	}

}
