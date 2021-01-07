package dataDrivenFramewor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Booking {
	
	WebDriver driver;
	String browser = "chrome";
	String URL = "https://www.booking.com/";
	String city = "New York, New York State, United States";
//	String checkIn = 
//	String checkOut = 
//			
	
	@BeforeMethod 
	public void beforeMethod() { 
		driver = DriverFactory.open(browser);
		driver.get(URL);
		
	  }
	
  @Test
  public void hotelRecervation() throws InterruptedException {
	
		driver.findElement(By.name("ss")).sendKeys(city);
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[5]")).click();
		driver.findElement(By.id("xp__guests__toggle")).click();
		driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")).click();
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"filter_filter-suggestions\"]/div[2]/a[1]/label/div")).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[3]/div[1]/a")).click();
		
		ArrayList <String> windows = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		String hotel = driver.findElement(By.id("hp_hotel_name")).getText();
		System.out.println("Hotel name: " + hotel);
		
		driver.findElement(By.xpath("//*[@id=\"group_recommendation\"]/table/tbody/tr/td[3]/table/tbody/tr[2]/td/a")).click();
		String price = driver.findElement(By.cssSelector("span[class='b-button__from-text']")).getText();
		System.out.println("Price - "+ price);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("2020"));
		
		
  }


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
