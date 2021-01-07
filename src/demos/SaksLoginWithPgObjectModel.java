package demos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PageObjectModel.logInPageFactory;
import PageObjectModel.WelcomePage;

public class SaksLoginWithPgObjectModel {
	
	WebDriver driver;
	
	@Before 
	public void setUp() {
		driver = dataDrivenFramewor.DriverFactory.open("chrome");
		driver.get("https://www.saksfifthavenue.com/");
	}
	
	@Test
	public void saksLoginTest() throws InterruptedException {
		
//		LogInPage lig= new LogInPage(driver);
//		lig.setEmail("qa3www@mailinator.com");
//		lig.setPassword("Qa1234567;");
//		lig.submit();
		
		logInPageFactory lipf = new logInPageFactory(driver);
		lipf.logIn("qa3www@mailinator.com", "Qa1234567;");
		
		WelcomePage wlp = new WelcomePage(driver);
		String welcomeName = wlp.getName();
		Assert.assertTrue(welcomeName.contains("Test"));
	}
	
	@After
	public void closingEverything() {
		driver.quit();
	}
	

}
