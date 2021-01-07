package demos;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaksLogin {
	WebDriver driver;

	@Test
	public void SaksLogin() throws InterruptedException {
		
		System.setProperty("webDriver.chrome.driver",
				"C:\\Users\\user\\Desktop\\Selenium.chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saksfifthavenue.com/");
		
		Thread.sleep(5000); //wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
		driver.findElement(By.id("consent-close")).click();   
		driver.findElement(By.className("sigin")).click();
		
		driver.findElement(By.id("login-form-email")).sendKeys("qa3www@mailinator.com");
		driver.findElement(By.id("login-form-password")).sendKeys("Qa1234567;");
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div/form/button")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div/form/div[1]")).getText());
		String pageTitle = driver.getTitle();
		

		Thread.sleep(5000);
		String welcomeName = driver.findElement(By.cssSelector("span[class='text-capitalize aven-H1-monetaff']")).getText();
		System.out.println("Welcome text - " + welcomeName);
		Assert.assertTrue(welcomeName.contains("Test"));
			
		driver.quit();
			
		}
		
	
	
	}


