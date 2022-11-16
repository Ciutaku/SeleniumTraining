package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverInit {
    private WebDriverInit() {
    }
    public static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }
}
