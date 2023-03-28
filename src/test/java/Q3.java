import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Q3 {
    static String letter;
    String input;

    @Factory(dataProvider = "dataMethod")
    public Q3(String letter) {
        input = letter;

    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] {{"y"} , {"x"} , {"İleti Gönder"}};
    }

    WebDriver driver = new ChromeDriver();

    @Test
    public void Login() {
        driver.get("https://webmailstudent.cankaya.edu.tr/?_task=logout&_token=Vh9ffibBNQTkvsMLg7gnhiWxinEJ0D39");
        driver.manage().window().maximize();
        WebElement user = driver.findElement(By.name("_user"));
        WebElement password = driver.findElement(By.name("_pass"));
        user.sendKeys("c2028031");
        password.sendKeys("16.06Mhfd");
        WebElement button = driver.findElement(By.id("rcmloginsubmit"));
        button.click();
        WebElement userName = driver.findElement(By.className("compose"));
        Assert.assertEquals(input, userName.getText());

    }


    @AfterClass
    public void quit() {
        driver.quit();
    }
    }

