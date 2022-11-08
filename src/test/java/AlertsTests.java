import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsTests {

    private String alertDemoPage = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private String testNameText = "Test Name Text";
    WebDriver driver;
    Alert alert;

    @BeforeAll
    static void setChromeDriverExecutable() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    void testAlertBoxTextResponse() {

        driver.get(alertDemoPage);
        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys(testNameText);
        alert.accept();
        WebElement resultText = driver.findElement(By.id("prompt-demo"));
        Assertions.assertEquals("You have entered '" + testNameText + "' !", resultText.getText());
    }

    @Test
    void testConfirmBoxCancel() {
        driver.get(alertDemoPage);
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement cancelResult = driver.findElement(By.id("confirm-demo"));
        Assertions.assertEquals("You pressed Cancel!", cancelResult.getText());

    }

    @Test
    void testConfirmBoxText() {
        driver.get(alertDemoPage);
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        alert = driver.switchTo().alert();
        Assertions.assertEquals("Press a button!", alert.getText());
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
