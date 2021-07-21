package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BikeWale {
	public ChromeDriver driver;
	public WebDriverWait wait;
	private Select sel;
	public JavascriptExecutor js;
	@Given("Go to https://www.bikewale.com/")
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.bikewale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	@And("Go to menu and click new bikes")
	public void clickNewBikes() {
		driver.findElementByXPath("//span[@class='navbarBtn nav-icon']").click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New Bikes']"))).click();
	}
	@And("Click New Bikes then compare bikes")
	public void clickCompareBikes() {
		driver.findElementByXPath("//a[text()='Compare Bikes']").click();
	}
	@And("Add first bike as Royal Enfield and model as Thunderbird 350")
	public void addFirstBike() {
		driver.findElementByXPath("//span[text()='1']/../span").click();
		driver.findElementByXPath("//div[@class='chosen-container chosen-container-single']").click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='chosen-results']//li[text()='Royal Enfield']"))).click();
		driver.findElementByXPath("//p[text()='model']/..//div[1]").click();
		List<WebElement> listElements = driver.findElementsByXPath("//ul[@class='chosen-results']//li");
		for (WebElement ele : listElements) {
			if(ele.getText().trim().equals("Thunderbird 350"))
			{
				ele.click();
			}
			
		}
	}
	@And("Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI")
	public void addSecondBike() throws Exception {
		driver.findElementByXPath("//span[text()='2']/../span").click();
		driver.findElementByXPath("(//p[text()='brand'])[2]/../div").click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='chosen-results']//li[text()='Jawa'])[2]"))).click();
		driver.findElementByXPath("(//p[text()='model'])[2]/../div").click();
		List<WebElement> listOfElements = driver.findElementsByXPath("//ul[@class='chosen-results']//li");
		for (WebElement element : listOfElements) {
			if(element.getText().trim().equals("42"))
			{
				element.click();
			}
		}
		driver.findElementByXPath("(//p[text()='version'])[2]/../div").click();
		List<WebElement> listOfVersion = driver.findElementsByXPath("//ul[@class='chosen-results']//li");
		for (WebElement version : listOfVersion) {
			if(version.getText().trim().equals("Dual Channel ABS - BS IV"))
			{
				version.click();
			}
		}
	}
		@And("Add bike brand Kawasaki model as Ninja 300")
		public void addNinjaBike(){
			driver.findElementByXPath("//span[text()='3']/../span").click();
			driver.findElementByXPath("(//p[text()='brand'])[3]/../div").click();
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='chosen-results']//li[text()='Kawasaki'])[3]"))).click();
			driver.findElementByXPath("(//p[text()='model'])[3]/../div").click();
			List<WebElement> listOfBikes = driver.findElementsByXPath("//ul[@class='chosen-results']//li");
			for (WebElement elements : listOfBikes) {
				if(elements.getText().trim().equals("Ninja 300"))
				{
					elements.click();
				
			}
			
			
		}
	
		
		
		
	}
		@And("click compare")
		public void clickCompare() throws Exception {
			driver.findElementByXPath("//button[text()='Compare now']").click();
			Thread.sleep(3000);
		}
	@When("Find and print the maximum overall rating of all the bikes and find the max")
		public void findMaxRating() throws Exception
		{
			List<WebElement> allBikes = driver.findElementsByXPath("//a[@class='item-target-link underline-none ']//p");
			List<WebElement>BikeModel=driver.findElementsByXPath("//a[@class='item-target-link underline-none ']/h2");
			List<WebElement> allRatings = driver.findElementsByXPath("//div[@class='rating-block']/span/span/following-sibling::span");
			WebElement reviewsEle = driver.findElementByXPath("(//li[text()='Reviews'])[2]");
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(7000);
			reviewsEle.click();
			List<WebElement> listRatings = driver.findElementsByXPath("//div[@class='rating-block']/span/span//following-sibling::span");
			List<Float>ratingsAsNum= new ArrayList<Float>();
			int count = 0;
			for (WebElement ele : listRatings) {
				ratingsAsNum.add(Float.parseFloat(ele.getText()));
				System.out.println("Bike Brands :" + allBikes.get(count).getText() + "Model :" + BikeModel.get(count).getText() + " Rating:"+ele.getText());
				count ++;
				}
			Float max = Collections.max(ratingsAsNum);
			System.out.println("Maximum Ratings for :" + allBikes.get(ratingsAsNum.indexOf(max)).getText() + " Rating : " + max);
		}
	
}
