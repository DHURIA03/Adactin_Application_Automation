package com.adactin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class generate {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://adactinhotelapp.com/");
		Thread.sleep(12);
		     
		//Login
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("AshishDhuri");
		driver.findElement(By.xpath(" ")).sendKeys("Ashish@123");
		Thread.sleep(12);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		//Extract Available location 
		
		 List<WebElement> country = driver.findElements(By.xpath("//select[@name='location']/option"));
		 for(WebElement option: country) 
		 {
			 System.out.println(option.getText());
		 }
		
		 // Print dropdown through select class
		 Select drop =new Select(driver.findElement(By.xpath("//select[@name='location']")));
		  List<WebElement> listB = drop.getOptions();
		  for(WebElement optionB : listB) 
		  {
			  System.out.println(optionB.getText());
		  }
		 
		 
		 
		 //Search Hotel by location
		Select DD = new Select(driver.findElement(By.name("location")));
		DD.selectByValue("London");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		//Select Hotel 
		driver.findElement(By.xpath("//input[@name='radiobutton_2']")).click();
		driver.findElement(By.xpath("//input[@name='continue']")).click();
		Thread.sleep(234);
		
		//Book A Hotel
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Narayan");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Thakare");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("At Post Pune, 312345");
		driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("1236547897412584");
		Select CC= new Select(driver.findElement(By.xpath("//select[@name='cc_type']")));
		CC.selectByValue("VISA");
		Select MM = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_month']")));
		MM.selectByIndex(7);
		Select YY = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_year']")));
		YY.selectByValue("2025");
		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("166");
		driver.findElement(By.xpath("//input[@name='book_now']")).click();
		Thread.sleep(10000);
		//String order_no = driver.findElement(By.xpath("//input[@name='order_no']")).getText();
		//System.out.println(order_no);
		String title = driver.findElement(By.xpath("//td[@class='login_title']")).getText();
		System.out.println(title);
		
		
		//Logout 
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
		
		
		
		

	}

}
