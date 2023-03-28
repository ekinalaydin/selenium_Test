import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Web {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void init(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> driver = null;
        }


    }

    @Test
    @Parameters("browser")
    public void Test1() {
        driver.get("https://webmailstudent.cankaya.edu.tr/");
        WebElement userName = driver.findElement(By.name("_user"));
        WebElement password = driver.findElement(By.name("_pass"));
        WebElement button = driver.findElement(By.id("rcmloginsubmit"));
        userName.sendKeys("c2028031");
        password.sendKeys("a");
        button.click();

    }

    @Test
    @Parameters("browser")
    public void Test2() {

        driver.get("https://webmailstudent.cankaya.edu.tr/");
        WebElement userName = driver.findElement(By.id("rcmloginuser"));
        WebElement password = driver.findElement(By.name("_pass"));
        WebElement button = driver.findElement(By.id("rcmloginsubmit"));
        userName.sendKeys("a");
        password.sendKeys("16.06Mhgd");
        button.click();


    }

    @Test
    @Parameters("browser")
    public void Test3() {
        driver.get("https://webmailstudent.cankaya.edu.tr/");
        WebElement userName = driver.findElement(By.id("rcmloginuser"));
        WebElement password = driver.findElement(By.name("_pass"));
        WebElement button = driver.findElement(By.id("rcmloginsubmit"));
        userName.sendKeys("c2028031");
        password.sendKeys("17.06Mhfd");
        button.click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("rcmbtn110")));
        WebElement quit = driver.findElement(By.id("rcmbtn110"));
        quit.click();

    }
    @AfterTest
    public void Quit(){
        driver.quit();
    }
}
