package dataDrivenFramewor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith (value = Parameterized.class)
public class newAccountDDTWithDriver {
	

	private static WebDriver driver;
	private static WebElement annual;
	private static WebElement estimated; 
	private static WebElement calculate;
	
	String name;
	String email;
	String phone;
	
	public newAccountDDTWithDriver (String name, String email, String phone, String gender, 
			String test1, String test2, String test3, String test4, String test5){
		this.name = name;
		this.email = email;
		this.phone = phone;	
	}
	
	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.open("chrome");
		driver.get("http://demo.guru99.com/insurance/v1/header.php");
		driver.findElement(By.id("ui-id-2")).click();
		
		annual = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
		estimated = driver.findElement(By.id("quotation_vehicle_attributes_value"));
		calculate = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[1]"));
	}
		
	@Test
	public void test() throws InterruptedException {
		annual.sendKeys(name);
		estimated.sendKeys("email");
		calculate.click();
//		Thread.sleep(10000);
//		String expected = driver.findElement(By.id("calculatedpremium")).getText();
//		String found = driver.findElement(By.id("calculatedpremium")).getText();
//		System.out.println(found);
//				
//		assertEquals(expected, found);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Parameters
	public static List<String[]> getData(){
		return csvFileReader.get("C:\\Users\\user\\Downloads\\UserAccounts.csv"); 
	}

}
