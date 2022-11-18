package pages;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver;

    public BaseTest() {
        driver = WebDriverInit.getDriver();
    }

    @AfterEach
    void tearDown() {
        BaseTest.cleanUp();
    }

    public static void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
