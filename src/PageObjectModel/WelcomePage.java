package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getName() throws InterruptedException {
		Thread.sleep(5000);
		String welcomeName = driver.findElement(By.cssSelector("span[class='text-capitalize aven-H1-monetaff']")).getText();
		return welcomeName;
	}

}
