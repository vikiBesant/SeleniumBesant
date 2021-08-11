package learnTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class EasyCoding {

	RemoteWebDriver driver;
	String expMessage;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
	}
	@BeforeClass
	public void maximize() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.findElementByLinkText("×").click();
	}
	@Test
	public void MainTest() {
		driver.findElementById("user-message").sendKeys("Murali");
	    driver.findElementByXPath("//button[text()='Show Message']").click();
	    expMessage=driver.findElementById("display").getText();
		System.out.println("The expected Message is  - " + expMessage);
	}
	@AfterMethod
	public void PostVal() {
		if(expMessage.contains("Murali"))
		{
			System.out.println("The Text is verified");
		}
	}
		@AfterTest
		public void shutWindow() {
			driver.close();
		}
	
}


