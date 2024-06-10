package com.shoppingcart.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shoppingcart.pages.checkoutPage;
import com.shoppingcart.pages.header;
import com.shoppingcart.pages.homePage;
import com.shoppingcart.pages.loginPage;
import com.shoppingcart.pages.myCartPage;
import com.shoppingcart.pages.orderConfirmationPage;
import com.shoppingcart.utilities.BaseClass;


public class TC003_PlacedOrder 
{
	@Test (dataProvider= "getData")
	public void TC003_placedOrder(String UN, String PW,String sample) throws Exception 
	{
		
        BaseClass.openApplication();
		
		loginPage.loginApplication(UN,PW); //provided Valid Login Credentials
		
		//To Add Item In Cart 
		homePage home = new homePage();
		home.addProductToCart(sample);
		home.waitForConfirmMessgae();
		home.waitTillConfirmMessgae();        
		BaseClass.takeScreenshot("TC003_ItemAddedInCart.png");
		 
		//To Click on Cart Button
		header cartbtn = new header();
		cartbtn.clickOnCartButton();
		Thread.sleep(2000);
		BaseClass.takeScreenshot("TC003_CartPageOpened.png");
		
		//Test Items are added in cart successfully
		myCartPage cartPage = new myCartPage();
		int noOfProducts = cartPage.validateNuberOfProductInCart();
		Assert.assertEquals(noOfProducts, 1);
		
		cartPage.verifyProductDisplayInCart();
		cartPage.clickOnCheckout();
		BaseClass.takeScreenshot("TC003_CheckoutPageOpened.png");
		
		//on checkout page provide country and ckick on placeorder Btn
		
		checkoutPage checkout = new checkoutPage();
		checkout.selectCountry("INDIA");
		BaseClass.takeScreenshot("TC003_CheckoutPageIndiaSelected.png");
		checkout.PlaceOrder();
		
		//Verify Success messgae
		orderConfirmationPage confirmPage = new orderConfirmationPage();
		String message = confirmPage.getConfirmationMessage();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		BaseClass.takeScreenshot("TC003_OrderConfirm.png");
		
		
		BaseClass.closeApplication();
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"Ashish@gamil.com","Ashish@123","IPHONE 13 PRO"},{"author@gamil.com","Ashish@123","ADIDAS ORIGINAL"}};
	}
}
