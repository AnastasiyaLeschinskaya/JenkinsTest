package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	WebDriver driver;
	
	public void setEmail(String email ) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("consent-close")).click();
		driver.findElement(By.className("sigin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-form-email")).sendKeys(email);
		
	}
	
	public void setPassword(String password) {
		driver.findElement(By.id("login-form-password")).sendKeys(password);
	}

	public void submit() {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div/form/button")).click();
		
	}
	
}
