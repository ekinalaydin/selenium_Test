
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        double[] prices = new double[3];

        driver.get("https://www.pt.com.tr/iphone-14-pro%22");

        WebElement price = driver.findElement(By.className("priceSizes"));

        prices[0] = parsePrice(price.getText());

        driver.get("https://www.troyestore.com/iPhone/iphone-14-pro?t=18315");

        price = driver.findElement(By.className("one-price"));

        prices[1] = parsePrice(price.getText());

        driver.get("https://www.mediamarkt.com.tr/tr/category/_iphone-14-pro-828524.html?searchParams=%2FSearch.ff%3FfilterTabbedCategory%3Donlineshop%26filterCategoriesROOT%3DApple%25C2%25A7MediaTRtrc644521%26filterCategoriesROOT%252FApple%25C2%25A7MediaTRtrc644521%3DiPhone%25C2%25A7MediaTRtrc644527%26filterCategoriesROOT%252FApple%25C2%25A7MediaTRtrc644521%252FiPhone%25C2%25A7MediaTRtrc644527%3DiPhone%2B14%2BPro%25C2%25A7MediaTRtrc828524%26filteravailability%3D1%26filterBellek_Kapasitesi%3D1%2BTB%26channel%3Dmmtrtr%26followSearch%3D9935%26disableTabbedCategory%3Dtrue%26navigation%3Dtrue&sort=suggested&view=&page=");

        price = driver.findElement(By.className("new-price"));

        prices[2] = parsePrice(price.getText());

        System.out.println("The cheapest iphone 14 pro: " + prices[0] + " TL");

        System.out.println("The average iphone 14 pro: " + prices[1] + " TL");

        System.out.println("The most expensive iphone 14 pro: " + prices[2] + " TL");

        System.out.println("The average price of iphone 14 pro: " + Arrays.stream(prices).average().getAsDouble());

        driver.quit();


    }
    private static double parsePrice(String priceInfo){

        String rawPrice = priceInfo.substring(0, 6);

        return Double.parseDouble(rawPrice);
    }
}
