import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTests {

    private String name = "selenium.t";
    private String password = "Tester12345!";
    private String homePage = "https://passport.yandex.com/";

    WebDriver driver;


    @BeforeAll
    static void setChromeDriverExecutable() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
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
        driver.findElement(By.xpath("//*[@class='UserID-Avatar ']")).click();
        Assertions.assertTrue(driver.getPageSource().contains(name));
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
