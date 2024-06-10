package com.shoppingcart.testscripts;

import org.testng.annotations.Test;

import com.shoppingcart.pages.loginPage;
import com.shoppingcart.utilities.BaseClass;

public class TC002_ValidLogin 
{
	@Test
	public void TC001_InvalidLogin() throws Exception 
	{
		BaseClass.openApplication();
		
		loginPage.loginApplication("Ashish@gamil.com","Ashish@123"); //provided Valid Login Credentials
		
		BaseClass.takeScreenshot("TC002_ValidLogin.png"); 
		
		BaseClass.closeApplication();
	}

}
