package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInPageFactory {

	
	public logInPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="consent-close")
	WebElement popUp;
	
	@FindBy(className = "sigin")
	WebElement signInButton;
	
	@FindBy(id = "login-form-email")
	WebElement emailField;
	
	@FindBy(id = "login-form-password")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div/div/div[1]/div/form/button")
	WebElement submitButton;
	
	
	public void setEmail(String email ) throws InterruptedException {
		Thread.sleep(5000);
		popUp.click();
		signInButton.click();
		Thread.sleep(5000);
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void submit() {
		submitButton.click();
	}
	
	public void logIn(String email, String password) throws InterruptedException {
		setEmail(email);
		setPassword(password);
		submit();
	}
	
}
