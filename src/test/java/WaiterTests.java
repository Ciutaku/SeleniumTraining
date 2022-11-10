import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaiterTests {
    FluentWait<WebDriver> wait;
    WebDriver driver;
    private static final String DYNAMIC_DATA_LOADING_URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    private static final String DOWNLOAD_PROGRESS_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private static final By SAVE_BUTTON = By.id("save");
    private static final By LOADER_GIF_ELEMENT = By.xpath("//*[contains(@src, 'loader-image.gif')]");
    private static final By PORTRAIT_IMAGE = By.xpath("//*[contains(@src, '.jpg')]");
    private static final By FIRST_NAME = By.xpath("//*[contains(text(), 'First')]");
    private static final By LAST_NAME = By.xpath("//*[contains(text(), 'Last')]");
    private static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private static final By PROGRESS_TEXT_ELEMENT_OF_FIFTY_PERCENT = By.xpath("//div[(text()='50%')]");

    @BeforeAll
    static void setChromeDriverExecutable() {WebDriverManager.getInstance(ChromeDriver.class).setup();}

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    void testUserGenerated() {
        driver.get(DYNAMIC_DATA_LOADING_URL);
        driver.findElement(SAVE_BUTTON).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADER_GIF_ELEMENT));
        WebElement portraitImage = driver.findElement(PORTRAIT_IMAGE);
        WebElement firstName = driver.findElement(FIRST_NAME);
        WebElement lastName = driver.findElement(LAST_NAME);
        assertAll("Verifies all elements are displayed",
                () -> assertTrue(portraitImage.isDisplayed()),
                () -> assertTrue(firstName.isDisplayed()),
                () -> assertTrue(lastName.isDisplayed()));
    }

    @Test
    void testRefreshOnReaching50Percent() {
        driver.get(DOWNLOAD_PROGRESS_URL);
        driver.findElement(DOWNLOAD_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROGRESS_TEXT_ELEMENT_OF_FIFTY_PERCENT));
        driver.navigate().refresh();
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
