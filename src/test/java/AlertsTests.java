import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsTests {

    private static final By RESULT_TEXT = By.id("prompt-demo");
    private static final String ALERT_DEMO_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static final String TEST_NAME_TEXT = "Test Name Text";
    private static final By PROMPT_BOX_BUTTON = By.xpath("//button[@onclick='myPromptFunction()']");
    private static final By CONFIRM_BOX_BUTTON = By.xpath("//button[@onclick='myConfirmFunction()']");
    private static final By CONFIRM_BOX_RESULT_TEXT = By.id("confirm-demo");
    private WebDriver driver;
    private Alert alert;

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
        driver.get(ALERT_DEMO_URL);
        driver.findElement(PROMPT_BOX_BUTTON).click();
        alert = driver.switchTo().alert();
        alert.sendKeys(TEST_NAME_TEXT);
        alert.accept();
        WebElement resultText = driver.findElement(RESULT_TEXT);
        Assertions.assertEquals("You have entered '" + TEST_NAME_TEXT + "' !", resultText.getText());
    }

    @Test
    void testConfirmBoxCancel() {
        driver.get(ALERT_DEMO_URL);
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement cancelResult = driver.findElement(CONFIRM_BOX_RESULT_TEXT);
        Assertions.assertEquals("You pressed Cancel!", cancelResult.getText());
    }

    @Test
    void testConfirmBoxText() {
        driver.get(ALERT_DEMO_URL);
        driver.findElement(CONFIRM_BOX_BUTTON).click();
        alert = driver.switchTo().alert();
        Assertions.assertEquals("Press a button!", alert.getText());
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
