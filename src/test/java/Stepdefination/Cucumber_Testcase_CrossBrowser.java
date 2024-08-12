package Stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class Cucumber_Testcase_CrossBrowser {
	ExtentReports extentreports; 
	ExtentTest test;
	
	WebDriver driver;
	
	@Given("user on the login page")
	public void user_on_the_login_page() {
		driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        usernameField.sendKeys(string);
        passwordField.sendKeys(string2);
	} 
 
	@Then("click submit button")
	public void click_submit_button() {
		  driver.findElement(By.id("submit")).click();
	}
 
	@And("user the login success message")
	public void user_the_login_success_message() {
		String Expected_Url="https://practicetestautomation.com/logged-in-successfully/"; 
	     
        String actual_Url= driver.getCurrentUrl();
         
   
    	    
          if (Expected_Url.equals(actual_Url)) {
          System.out.println("Login successfully with valid input data" );
          } else {
        	  System.out.println("Login failed with Invalid Inputdata"); 
          }  
          driver.quit(); 
	}
	
	   

	
}
