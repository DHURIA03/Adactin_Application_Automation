package com.shoppingcart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shoppingcart.utilities.BaseClass;

public class homePage extends BaseClass
{
	
	//Objects
	@FindBy(css= ".mb-3")
	List<WebElement> products ;
	
	static By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
	static By productFrame = By.cssSelector(".mb-3");
	static By waitFor      = By.cssSelector("#toast-container");
	static By waitTill      = By.cssSelector(".ng-animating");
	
	// Actions
	
	public List<WebElement> getProductList() 
	{
		waitForElement(productFrame);
		products = driver.findElements(productFrame);
		
		return products;
	}
	
	public  WebElement getProductByName(String shopingProduct) 
	{
		WebElement target = getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().
		equals(shopingProduct)).findFirst().orElse(null);
		
		
		return target;
		
	}
	
	public void addProductToCart(String productName ) 
	{
		WebElement proctctIs = getProductByName(productName);
		proctctIs.findElement(addToCartBtn).click();
		
	}
	
	public void waitForConfirmMessgae() 
	{
		waitForElement(waitFor);
	}
	
	public void waitTillConfirmMessgae() throws Exception 
	{
		//waitForElement(waitTill);
		Thread.sleep(1000);
	}
	
	
	
	

	

}
