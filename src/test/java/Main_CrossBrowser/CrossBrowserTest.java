package Main_CrossBrowser;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CrossBrowserTest {
	 WebDriver driver;
	 
	 public static ExtentReports extentreports; 
	 ExtentTest test; 
	 
	    @Parameters("browser")
	    @BeforeClass
	    public void setup(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }
	        driver.manage().window().maximize();
	    }
	    
	    
	    @BeforeSuite
	    public void initializeExtentReports() {
	        extentreports = new ExtentReports();
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("AllTestReport.html");
	        extentreports.attachReporter(sparkReporter);
	    }
	    
	    @AfterSuite
	    public void generateExtentReports() throws IOException {
	        extentreports.flush();
	        File reportFile = new File("AllTestReport.html");
	       
	        Desktop.getDesktop().browse(reportFile.toURI());
	        }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) throws InterruptedException {
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("submit")).click();
	         
	        Thread.sleep(2000); 
	        
	           String Expected_Url="https://practicetestautomation.com/logged-in-successfully/"; 
	     
	          String actual_Url= driver.getCurrentUrl();
	           
	      
	        	 test=extentreports.createTest("Test 1"); 
	      	    
	            if (Expected_Url.equals(actual_Url)) {
	            	test.pass("Login successfully with valid input data" );
	            } else {
	               test.fail("Login failed with Invalid Inputdata"); 
	            }  
	    
	    }

	    @DataProvider(name = "loginData")
	  /*  public Object[][] getData() throws IOException {
	        return readExcelData("C:\\Users\\saaluvala\\OneDrive - Copart, Inc\\Desktop\\TestData.xlsx", 0);
	    }
*/
	    public Object[][] readExcelData() throws IOException {
	        File file = new File("C:\\Users\\saaluvala\\OneDrive - Copart, Inc\\Desktop\\TestData.xlsx");
	        FileInputStream fis = new FileInputStream(file);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheetAt(1);

	        int rowcount = sheet.getPhysicalNumberOfRows();
	        XSSFRow row = sheet.getRow(0);
	        int cellcount = row.getPhysicalNumberOfCells();

	        List<Object[]> data = new ArrayList<>();
	        
	        for (int i = 1; i < rowcount; i++) {
	            XSSFRow rowvalue = sheet.getRow(i);
	            String username = rowvalue.getCell(1).getStringCellValue();
	            String password = rowvalue.getCell(2).getStringCellValue();
	            
	            System.out.println("||" + username + "||" +password);
	            data.add(new Object[]{username, password});
	    
	        }
	        workbook.close(); 
	        fis.close();
	        return data.toArray(new Object[0][0]); 
	       
	    
	    }

	    @AfterClass
	    public void tearDown() {
	     if(driver!=null) {
	            driver.quit();
	     }
	    }
	}
