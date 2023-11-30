package com.adactin.lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class General extends Global
{
	WebDriver driver = new ChromeDriver();
	
	public void OpenApplication()
	{
		driver.navigate().to(url);
		String title =driver.getTitle();
		System.out.println(title);	
	}
	
	public void Login() throws Exception
	{
		driver.findElement(By.xpath(USerName_path)).sendKeys(USerName);
		driver.findElement(By.xpath(PassWord_path)).sendKeys(PassWord);
		driver.findElement(By.xpath(LoginBtn)).click();
		Thread.sleep(1200);	
	}
	
	public void PrintLocations() 
	{
		List<WebElement> country = driver.findElements(By.xpath(CountryOptions));
		for(WebElement option: country) 
		 {
			 System.out.println(option.getText());
		 }
		
	}
	
	public void SearchHotel() 
	{
		Select DD = new Select(driver.findElement(By.name("location")));
		DD.selectByValue("London");
		driver.findElement(By.xpath(SearchBtn)).click();
		
	}
	
	public void SelectHotel() throws Exception
	{
		driver.findElement(By.xpath("//input[@name='radiobutton_2']")).click();
		driver.findElement(By.xpath(ContinueBtn)).click();
		Thread.sleep(234);
	}
	
	public void BookHotel()throws Exception
	{
		driver.findElement(By.xpath(First_Name)).sendKeys("Suryakumar");
		driver.findElement(By.xpath(Last_Name)).sendKeys("Yadav");
		driver.findElement(By.xpath(Address)).sendKeys("At Post Pune, 312345 Yadavwadi");
		driver.findElement(By.xpath(CC_No)).sendKeys("1234567891011123");
		
		Select CC= new Select(driver.findElement(By.xpath(VISA)));
		CC.selectByValue("VISA");
		
		Select MM = new Select(driver.findElement(By.xpath(CC_Exp_Month)));
		MM.selectByIndex(7);
		
		Select YY = new Select(driver.findElement(By.xpath(CC_Exp_Year)));
		YY.selectByValue("2025");
		
		driver.findElement(By.xpath(CC_CVV)).sendKeys("167");
		driver.findElement(By.xpath(Book_Now_Btn)).click();
		Thread.sleep(10000);
		String title = driver.findElement(By.xpath(Login_Title)).getText();
		System.out.println(title);
	}
	
	public void logout() 
	{
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public void CloseBrowser()
	{
		driver.close();
	}
 
	

 }
