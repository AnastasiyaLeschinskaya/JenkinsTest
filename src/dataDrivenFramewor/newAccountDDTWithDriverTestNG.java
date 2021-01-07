package dataDrivenFramewor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class newAccountDDTWithDriverTestNG {

	private static WebDriver driver;
	private static WebElement annual;
	private static WebElement estimated; 
	private static WebElement calculate;
	
	String name;
	String email;
	String phone;
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.open("chrome");
		driver.get("http://demo.guru99.com/insurance/v1/header.php");
		driver.findElement(By.id("ui-id-2")).click();
		
		annual = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
		estimated = driver.findElement(By.id("quotation_vehicle_attributes_value"));
		calculate = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[1]"));
	}
		
	@Test(dataProvider = "getData")
	public void test(String name, String email, String password) throws InterruptedException {
		annual.sendKeys(email);
		estimated.sendKeys(password);
		calculate.click();
		Thread.sleep(10000);
//		String expected = driver.findElement(By.id("calculatedpremium")).getText();
//		String found = driver.findElement(By.id("calculatedpremium")).getText();
//		System.out.println(found);
//				
//		assertEquals(expected, found);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@DataProvider
	public static String[][] getData(){
		return excelReader.get("C:\\Users\\user\\Downloads\\UserLogin.xls"); 
	}

}
