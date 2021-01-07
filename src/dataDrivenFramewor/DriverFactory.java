package dataDrivenFramewor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  DriverFactory {
	
	public static WebDriver open(String browserType) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		if (browserType.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		} else {
			return new ChromeDriver();
		}
	}
}
