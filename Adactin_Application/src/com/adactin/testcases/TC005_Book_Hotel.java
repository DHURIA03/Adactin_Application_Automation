package com.adactin.testcases;

import org.testng.annotations.Test;

import com.adactin.lib.General;

public class TC005_Book_Hotel {

	//public static void main(String[] args) throws Exception 
	@Test(priority=5)
	public void TC005() throws Exception
	{
		
		General obj = new General();
		obj.OpenApplication();
		Thread.sleep(10);
		obj.Login();
		Thread.sleep(10);
		obj.SearchHotel();
		Thread.sleep(10);
		obj.SelectHotel();
		Thread.sleep(10);
		obj.BookHotel();
		Thread.sleep(10);
		obj.logout();
		Thread.sleep(10);
		obj.CloseBrowser();

	}

}
