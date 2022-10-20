import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {


    private static String chromeDriverPath = "C:\\chromedriver_win32\\chromedriver.exe";
    private String name = "selenium.t";
    private String password = "Tester12345!";
    private String homePage = "https://passport.yandex.com/";

    WebDriver driver;


    @BeforeAll
    static void setChromeDriverPath() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void goToLoginPageAndLogIn() throws InterruptedException {
        driver.get(homePage);
        driver.findElement(By.id("passp-field-login")).sendKeys(name);
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(1000); //temporary until I reach task with "Waits"
        driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(2000); //temporary until I reach task with "Waits"
        Assert.assertEquals(homePage, driver.getCurrentUrl());
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
