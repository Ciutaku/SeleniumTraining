import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInTest {

    private static final By SUBNAME_ELEMENT = By.xpath("//*[contains (@class, 'Subname')]");
    private static final By LOGIN_FIELD = By.id("passp-field-login");
    private static final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final By USER_AVATAR = By.xpath("//*[@class='UserID-Avatar ']");
    private static final String PASSWORD = "Tester123456!";
    private static final String HOMEPAGE = "https://passport.yandex.com/";
    WebDriver driver;

    @BeforeAll
    static void setChromeDriverExecutable() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @ParameterizedTest
    @ValueSource(strings = {"selenium.t", "selenium.t2"})
    void goToLoginPageAndLogIn(String testName) throws InterruptedException {
        driver.get(HOMEPAGE);
        driver.findElement(LOGIN_FIELD).sendKeys(testName);
        driver.findElement(SIGN_IN_BUTTON).click();
        Thread.sleep(1000);
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);
        driver.findElement(SIGN_IN_BUTTON).click();
        driver.findElement(USER_AVATAR).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(SUBNAME_ELEMENT));
        assertTrue(driver.findElement(SUBNAME_ELEMENT).isDisplayed());
    }
    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
