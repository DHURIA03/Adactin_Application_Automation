package com.adactin.testcases;

import org.testng.annotations.Test;

import com.adactin.lib.General;

public class TC004_Select_Hotel 
{
	//public static void main(String[] args) throws Exception
	@Test(priority=4)
	public void TC004() throws Exception
	{
		General obj = new General();
		obj.OpenApplication();
		Thread.sleep(1000);
		obj.Login();
		Thread.sleep(1000);
		obj.SearchHotel();
		Thread.sleep(1000);
		obj.SelectHotel();
		obj.logout();
		Thread.sleep(1000);
		obj.CloseBrowser();
	}

}
