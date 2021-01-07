package stepsImplementation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjectModel.WelcomePage;
import PageObjectModel.logInPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("^saks account login page$")
	public void saks_account_login_page() throws InterruptedException {
		driver = dataDrivenFramewor.DriverFactory.open("chrome");
		driver.get("https://www.saksfifthavenue.com/");
	}
	
	@When("^user entered email and password$") 
	public void user_entered_email_and_password() throws InterruptedException {
		logInPageFactory lipf = new logInPageFactory(driver);
		
			lipf.logIn("qa3www@mailinator.com","Qa1234567;");
	}
	
	
	@When("^entered email (.*)")
	public void entered_email(String email) throws InterruptedException {
		Thread.sleep(5000); 
		driver.findElement(By.id("consent-close")).click();   
		driver.findElement(By.className("sigin")).click();
		driver.findElement(By.id("login-form-email")).sendKeys(email);
	}
	
	@And("^entered password (.*)$") 
	public void entered_password(String password){
		driver.findElement(By.id("login-form-password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div/form/button")).click();
	}
		
		
	@Then("^users should see their name$")
	public void users_should_see_their_name() throws InterruptedException {
		WelcomePage wlp = new WelcomePage(driver);
		
		String welcomeName = wlp.getName();
		Assert.assertTrue(welcomeName.contains("Test"));
		driver.quit();
	
	}

}
