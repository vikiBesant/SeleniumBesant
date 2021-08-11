package selDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EasyCode {
	@Test
	public void M1() {

	
	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.findElementByLinkText("×").click();
		driver.findElementById("user-message").sendKeys("Murali");
		WebElement store = driver.findElementByXPath("//button[text()='Show Message']");
		String expMessage = driver.findElementById("display").getText();
		System.out.println("The expected Message is  - " + expMessage);
	

		if(expMessage.contains("Murali"))
		{
			System.out.println("The Text is verified");
		}
		
		
		driver.close();

	}

}
