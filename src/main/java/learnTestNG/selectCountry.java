package learnTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test
public class selectCountry {

	public void m1(){
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		//driver.findElementById("countries").click();
		WebElement dd1 = driver.findElementById("countries");
		Select dd = new Select(dd1);
		dd.selectByVisibleText("India");
		WebElement dd2 = driver.findElementById("Skills");
		Select ddSkills = new Select(dd2);
		ddSkills.selectByValue("Android");
		
		

	}

}
