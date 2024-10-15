package naukriUpdate.NaukriUpdate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() throws InterruptedException, MalformedURLException {
        assertTrue(true);
        WebDriver driver = null;

        Optional<String> platform = Optional.ofNullable(System.getProperty("platform"));
        if (platform.isPresent()) {
            if (platform.get().equalsIgnoreCase("remote")) {
                ChromeOptions co = new ChromeOptions();
                co.setPlatformName("linux");
                co.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), co);

            } else if (platform.get().equalsIgnoreCase("local")) {
                driver = new ChromeDriver();
            }
            else {
                System.out.println("Incorrect input of platform....setting to chromedriver");
                driver = new ChromeDriver();
            }

        } else {
            driver = new ChromeDriver();
        }

        try {


            //WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.get("https://www.naukri.com/mnjuser/homepage");
            Thread.sleep(5000);
            driver.findElement(By.id("usernameField")).sendKeys("erjoshivaibhav@gmail.com");
            driver.findElement(By.id("passwordField")).sendKeys("Vaibhav@123");
            driver.findElement(By.xpath("//button[text()='Login']")).click();
            Thread.sleep(5000);
            driver.navigate().refresh();
            driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a")).click();
            Thread.sleep(5000);
            List<WebElement> temp = driver.findElements(By.xpath("//div[contains(@class,'crossIcon')]"));
            if (!temp.isEmpty()) {
                driver.findElement(By.xpath("//div[contains(@class,'crossIcon')]")).click();

            }
            Actions action = new Actions(driver);
            WebElement ele = driver.findElement(By.xpath("//span[@class='widgetTitle typ-16Bold' and contains(text(),'Resume headline')]//following-sibling::span"));
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
        } catch (Exception e) {
            System.out.println("Exception is :" + e.getMessage());
        } finally {
            driver.quit();

        }


//			Assert.assertEquals(null, null);


    }


}
