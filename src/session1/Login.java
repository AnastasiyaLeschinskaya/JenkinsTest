package session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Go to https://www.guru99.com/selenium-tutorial.html
//Work through tutorials 
//"Find Element and FindElements in Selenium WebDriver" and 
//"Selenium Form WebElement: TextBox, Submit Button, sendkeys(), click()"
//Navigate to http://demo.guru99.com/test/newtours/
//Create a Selenium program to enter a user name and password and log into the demo site (it works with any username and password).
//Visually verify that the login worked.


public class Login {

	public static void main(String[] args) throws InterruptedException {
		
	//System.setProperty("webDriver.chrome.driver",
	//					"C:\\Users\\user\\Desktop\\Selenium.chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("Test@test.com");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("Test123");
		driver.findElement(By.name("submit")).click();

	}
}

