package com.adactin.testcases;

import org.testng.annotations.Test;

import com.adactin.lib.General;

public class TC003_Print_Dropdown_Location_Values 
{
	//public static void main (String[] args) throws Exception
	@Test(priority=3)
	public void TC003() throws Exception
	{
		General obj = new General();
		obj.OpenApplication();
		Thread.sleep(1000);
		obj.Login();
		Thread.sleep(1000);
		obj.PrintLocations();
		Thread.sleep(1000);
		obj.logout();
		Thread.sleep(1000); 
		obj.CloseBrowser();
	}

}
