package Main_CrossBrowser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports_CrossBrowser {

	 
	 
	 
public static void main(String[] args) throws IOException { 

	 
	   ExtentReports extentreports=new ExtentReports();
   	ExtentSparkReporter sparkreporter_all=new ExtentSparkReporter("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\AllTestReport.html");
  
   	ExtentSparkReporter sparkreporter_pass=new ExtentSparkReporter("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\PassTestReport.html");
   	ExtentSparkReporter sparkreporter_fail=new ExtentSparkReporter("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\FailTestReport.html");
   ExtentSparkReporter sparkreporter_skip=new ExtentSparkReporter("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\SkipTestReport.html");

   	 
   	
   extentreports.attachReporter(sparkreporter_all, sparkreporter_pass, sparkreporter_fail, sparkreporter_skip);
	
   	extentreports.attachReporter(sparkreporter_all);
	//Generate the report for only failed Test case
    sparkreporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply(); 
	
	//Generate the report for Passed and Skipped Testcases in all testcases
	sparkreporter_all.filter().statusFilter().as(new Status[] 
			{Status.PASS, 
			 Status.SKIP
					 
			}).apply(); 
	
	//Generate the report for Passed Testcases in passed testcases
	sparkreporter_pass.filter().statusFilter().as(new Status[] 
			{Status.PASS,
			
					
			}).apply(); 

	
/*		
	//manually write test status
	ExtentTest test1=extentreports.createTest("Test 1"); 
	test1.pass("This is Pass1");
	
	ExtentTest test2=extentreports.createTest("Test 2"); 
	test2.log(Status.FAIL, "This is Failed1"); 
	
	ExtentTest test3=extentreports.createTest("Test 3"); 
	test3.skip("This is skipped1");
*/

/*		
	extentreports.createTest("Test 1")
	.log(Status.INFO, "info 1")
	.log(Status.SKIP, "Skip")
	.log(Status.PASS, "passed")
	
	.log(Status.PASS, "passed")
	 
	.log(Status.INFO, "info 2")
	.log(Status.WARNING, "Warning")
	.log(Status.SKIP, "Skip");
*/
	
	extentreports.createTest("Test 1", "Application login with valid inputdata")
	.assignAuthor("Saichand Aluvala")
	.assignCategory("SmokeTest")
	.assignDevice("Chrome 127")
	.pass("This is passed testcase"); 
	
	extentreports.createTest("Test 1", "login succsfull message")
	.assignAuthor("Saichand Aluvala")
	.assignCategory("SmokeTest")
	.assignDevice("Chrome 127")
	.pass("This is passed testcase"); 
	
	
	extentreports.createTest("Test 2", "Application login with Invalid inputdata")
	.assignAuthor("Saichand Aluvala")
	.assignCategory("ReTest")
	.assignDevice("Chrome 127")
	.fail("This is failed testcase"); 
	
	extentreports.createTest("Test 2", "Application logout button after login with valid inputdata")
	.assignAuthor("Saichand Aluvala")
	.assignCategory("RegressionTest") 
	.assignDevice("Chrome 127")
	.skip("This is skipped testcase");  
	 
	
   
	//show the reports at file manager
	
	extentreports.flush(); 
	 
	
	//show the report in browser automatically
	Desktop.getDesktop().browse(new File("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\AllTestReport.html").toURI()); //passes&skip
	Desktop.getDesktop().browse(new File("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\FailTestReport.html").toURI()); //fail
	Desktop.getDesktop().browse(new File("C:\\Users\\saaluvala\\Elipse-JavaBasics\\TestNG_CrossBrowser\\PassTestReport.html").toURI()); //pass

	}
	}


