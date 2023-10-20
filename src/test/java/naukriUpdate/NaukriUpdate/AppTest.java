package naukriUpdate.NaukriUpdate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeOptions;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import naukriUpdate.NaukriUpdate.AppTest;



/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	 public AppTest( String testName )
	    {
	        super( testName );
	    }
	 
	 public static Test suite()
	    {
	        return new TestSuite( AppTest.class );
	    }
	
	 public void testApp() throws InterruptedException
	    {
	        assertTrue( true );
	        
	       
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			driver.get("https://www.naukri.com/mnjuser/homepage");
			driver.findElement(By.id("usernameField")).sendKeys("erjoshivaibhav@gmail.com");
			driver.findElement(By.id("passwordField")).sendKeys("Vaibhav@123");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a")).click();
			Thread.sleep(5000);
			List<WebElement> temp = driver.findElements(By.xpath("//div[contains(@class,'crossIcon')]"));
			if(temp.size()>0) {
				driver.findElement(By.xpath("//div[contains(@class,'crossIcon')]")).click();

			}
			Actions action= new Actions(driver);
			WebElement ele= driver.findElement(By.xpath("//span[@class='widgetTitle typ-16Bold' and contains(text(),'Resume headline')]//following-sibling::span"));
			action.scrollToElement(ele);
			driver.findElement(By.xpath("//span[@class='widgetTitle typ-16Bold' and contains(text(),'Resume headline')]//following-sibling::span")).click();
			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']")).isDisplayed();
			driver.findElement(By.id("resumeHeadlineTxt")).sendKeys("Experienced");
			driver.findElement(By.xpath("//div[contains(@class,'action')]//button[@type='submit']")).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//span[@class='widgetTitle typ-16Bold' and contains(text(),'Resume headline')]//following-sibling::span")).click();
			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']")).isDisplayed();
			driver.findElement(By.id("resumeHeadlineTxt")).clear();
			driver.findElement(By.id("resumeHeadlineTxt")).sendKeys("ISTQB Certified Test Automation Engineer with Java,Selenium,Cucumber,Maven,TestNg etc. skills. with 4 Years of Corporate Experience.");
			driver.findElement(By.xpath("//div[contains(@class,'action')]//button[@type='submit']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[text()='ISTQB Certified Test Automation Engineer with Java,Selenium,Cucumber,Maven,TestNg etc. skills. with 4 Years of Corporate Experience.']")).isDisplayed();
			System.out.println("Done");
//			Assert.assertEquals(null, null);
			driver.quit();
	        
	    }
	 
    
	
}
