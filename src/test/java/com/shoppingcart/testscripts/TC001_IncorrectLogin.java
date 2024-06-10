package com.shoppingcart.testscripts;

import org.testng.annotations.Test;
import com.shoppingcart.pages.loginPage;
import com.shoppingcart.utilities.BaseClass;


/*Verify providing incorrect credential user is unable to 
 * access shoppingcart application.*/

public class TC001_IncorrectLogin extends BaseClass
{
	@Test
	public void TC001_InvalidLogin() throws Exception 
	{
		BaseClass.openApplication();
		Thread.sleep(5000);
		loginPage.loginApplication("AshishDhuri@gamil.com","Ashish@123");//provided Invalid Login Credentials
		
		BaseClass.takeScreenshot("TC001_IncorrectLogin.png");
		
		BaseClass.closeApplication();
	}
	

}
