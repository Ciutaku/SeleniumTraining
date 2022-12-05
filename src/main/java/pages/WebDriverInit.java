package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverInit {

    private static WebDriver driver;

    private WebDriverInit() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
