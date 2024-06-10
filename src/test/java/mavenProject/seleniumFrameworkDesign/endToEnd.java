package mavenProject.seleniumFrameworkDesign;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;

public class endToEnd {

	public static void main(String[] args)  throws Exception
	{
		// TODO Auto-generated method stub
		  
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Ashish@gamil.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ashish@123");
		driver.findElement(By.id("login")).click(); 
		
		//ShoppingPage
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("C:\\Users\\Ashish\\Desktop\\Python\\png1.png"));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//for(WebElement product : Products) 
		
		//driver.findElement(By.xpath("(//input[@placeholder='search'])[2]")).sendKeys("IPHONE");
		//driver.findElement(By.xpath("(//input[@placeholder='search'])[2]")).sendKeys(Keys.ENTER);
		//driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		String shopingProduct = "IPHONE 13 PRO";
		
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().
		equals(shopingProduct)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    
	    //Cart Header
		
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		
		//cart page
		
		
		List<WebElement> cartElement = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		int count = cartElement.size();		
		for (WebElement cart :cartElement) 
		{
			System.out.println(cart.getText());
			Assert.assertEquals(cart.getText(), shopingProduct);
			
		}   
		
		System.out.println(count);
		
		driver.findElement(By.xpath("//li/button[@class='btn btn-primary']")).click();
		
		//checkoutPage
		
		Actions select = new Actions(driver);
		select.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item:last-of-type")));
		
		driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		driver.findElement(By.cssSelector(".action__submit")).click(); 
		
		//ConfirmationPage  
		
		String finalMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(finalMessage, "THANKYOU FOR THE ORDER.");
		
		
		
		

	}

}
