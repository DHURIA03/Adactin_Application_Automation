package com.adactin.testcases;

import org.testng.annotations.Test;

import com.adactin.lib.General;

public class TC002_SearchHotel 
{
	//public static void main(String[] Args) throws Exception 
	@Test(priority=2)
	public void TC002() throws Exception
	{
		General obj = new General();
		obj.OpenApplication();
		Thread.sleep(1000);
		obj.Login();
		Thread.sleep(1000);
		obj.SearchHotel();
		Thread.sleep(1000);
		obj.logout();
		Thread.sleep(1000);
		obj.CloseBrowser();
	}

}
