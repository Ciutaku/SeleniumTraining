import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSelectTest {

    private static final String MULTI_SELECT_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private static final By MULTI_SELECT = By.id("multi-select");
    private WebDriver driver;

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

    @Test
    public void multiSelectTest() {
        driver.get(MULTI_SELECT_URL);
        Select multiSelect = new Select(driver.findElement(MULTI_SELECT));
        List<String> expectedStates = new Random().ints(3, 0, multiSelect.getOptions().size()).boxed()
                .map(i -> multiSelect.getOptions().get(i).getText()).collect(Collectors.toList());
        expectedStates.forEach(multiSelect::selectByValue);
        List<String> selectedStates = multiSelect.getAllSelectedOptions().stream().map(WebElement::getText)
                .collect(Collectors.toList());
        assertTrue(expectedStates.containsAll(selectedStates));
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}
