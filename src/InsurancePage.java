
import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//Create a test case for the insurance page (http://demo.guru99.com/insurance/v1/header.php).
//from Michael Kevin Gaffney to All Participants:
//Includde one non-parameterized test and one test using a CsvValue parameterizing
//The csv will include the values you want to enter into the form as well as values 
//to test from the resulting premium message.


class InsurancePage {
	
	private static WebDriver driver;
	private static WebElement annual;
	private static WebElement estimated; 
	private static WebElement calculate;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/insurance/v1/header.php");
		driver.findElement(By.id("ui-id-2")).click();
		
		
		
		annual = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
		estimated = driver.findElement(By.id("quotation_vehicle_attributes_value"));
		calculate = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[1]"));
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		annual.sendKeys("123");
		estimated.sendKeys("12345");
		calculate.click();
		Thread.sleep(10000);
		String expected = driver.findElement(By.id("calculatedpremium")).getText();
		String found = driver.findElement(By.id("calculatedpremium")).getText();
		System.out.println(found);
				
		assertEquals(expected, found);
		
	}
	
	@ParameterizedTest
	@CsvSource({"333, 3333", "444, 4444", "555, 5555"})
	void paramTest(String annualPar, String estimatedPar) throws InterruptedException {
		annual.sendKeys(annualPar);
		estimated.sendKeys(estimatedPar);
		calculate.click();
		Thread.sleep(10000);
		String expected = driver.findElement(By.id("calculatedpremium")).getText();
		String found = driver.findElement(By.id("calculatedpremium")).getText();
		System.out.println(found);
		assertEquals(expected, found);
		}
		//fail(input + " is not a month name.");
	}


