package class1;

import org.openqa.selenium.Alert; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Maven {

	public static void main(String[] args) throws Exception {
		System.out.println("Test"); 
		System.setProperty("wedriver.chrome.driver", "C:/Program Files/Java/chromedriver-win64/chromedriver-win64/chromedriver.exe");
            WebDriver driver=new ChromeDriver(); 
          
            driver.manage().window().maximize();  
           
            
            System.out.println("Chromerowser was opened successfully");
            
            driver.get("https://www.youtube.com/");
            driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Kalki telugu trailer");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']//div")).click(); 
            Thread.sleep(2000);
            driver.findElement(By.xpath("//yt-formatted-string[@aria-label='Kalki 2898 AD Trailer - Telugu | Prabhas | Amitabh Bachchan | Kamal Haasan | Deepika | Nag Ashwin by Vyjayanthi Network 24,491,329 views 8 days ago 3 minutes, 3 seconds']")).click();
          
            
            
            
            //  driver.close();

	}

}
