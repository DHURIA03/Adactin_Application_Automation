package com.adactin.testcases;



import org.testng.annotations.Test;

import com.adactin.lib.General;

public class TC001_Login 
{
	//public static void main(String[] args) throws Exception 
	@Test(priority=1)
	public void TC001() throws Exception
	{
		General obj = new General();
		obj.OpenApplication();
		Thread.sleep(10);
		obj.Login();
		Thread.sleep(10);
		obj.logout();
		Thread.sleep(10);
		obj.CloseBrowser();
		
		
	}

}
