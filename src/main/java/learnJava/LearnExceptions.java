package learnJava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class LearnExceptions {
	public void m2() {

	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.findElementByLinkText("×").click();
				try {
		driver.findElementById("user-messag").sendKeys("Murali");
		}
		catch (NoSuchElementException e)
		{
	       System.err.println("Element does not exist"); 	
		}
		try {
			driver.findElementByClassName("btn btn-default").click();
		}
   catch(Exception t)
{
	System.err.println("The expection exception is " + t);
}
	}
}


