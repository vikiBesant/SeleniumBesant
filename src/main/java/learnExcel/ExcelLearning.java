package learnExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelLearning {
	@DataProvider(name ="testdata")
	public static Object[][] readExcel() throws Exception {
		XSSFWorkbook wbook = new XSSFWorkbook("C://Users//Gayathri//Desktop//SeleniumBesant//data//TestData.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int rowcount = sheet.getLastRowNum();
	    int colCount = sheet.getRow(0).getLastCellNum();
	    System.out.println(rowcount + colCount);
	    Object[][] data = new Object[rowcount][colCount];
	    for(int i=0; i<rowcount; i++)
	    {
	    	XSSFRow row = sheet.getRow(i);
	    	for(int j=0; j<colCount; j++)
	    	{
	    		XSSFCell cell = row.getCell(j);
	    		String value = cell.getStringCellValue();
	    		data[i][j] = value;
	    		System.out.println(value);
	    	}
	    }
		return data;
				
	}				
@Test(dataProvider="testdata")
public void demoSite(String UserName, String Password, String url) {
	
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElementByName("uid").sendKeys(UserName);
	driver.findElementByName("password").sendKeys(Password);
		
		
	}

}
