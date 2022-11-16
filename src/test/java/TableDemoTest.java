import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TableDemoTest {
    private static final By NEXT_BUTTON = By.className("next");
    private static final By TABLE_ROWS = By.xpath("//tr[@role='row']");
    private static final By SALARY_CELL = By.xpath("//td[6]");
    private static final By SHOW_ENTRIES_SELECTOR = By.name("example_length");
    private static final By SHOWING_ITEMS = By.id("example_info");
    private static final By AGE_CELL = By.xpath("//td[4]");
    private static final By NAME_CELL = By.xpath("//td[1]");
    private static final By POSITION_CELL = By.xpath("//td[2]");
    private static final By OFFICE_CELL = By.xpath("//td[3]");
    private static final String TABLE_DEMO_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
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
    public void collectEmployees() {
        driver.get(TABLE_DEMO_URL);
        Select select = new Select(driver.findElement(SHOW_ENTRIES_SELECTOR));
        select.selectByValue("10");
        new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(50))
                .until(driver -> driver.findElement(SHOWING_ITEMS).getText().contains("Showing 1 to 10"));
        List<Employee> listFromWeb = getEmployeeByCondition(30, 300000);
    }

    public List<Employee> getEmployeeByCondition(int minAge, int maxSalary) {
        List<Employee> employees = new ArrayList<>();
        do {
            WebElement nextBtn = driver.findElement(NEXT_BUTTON);
            collectEmployeesByCondition(minAge, maxSalary, employees);
            nextBtn.click();
        } while (!driver.findElement(NEXT_BUTTON).getAttribute("class").contains("disabled"));
        collectEmployeesByCondition(minAge, maxSalary, employees);
        return employees;
    }

    public void collectEmployeesByCondition(int minAge, int maxSalary, List<Employee> employees) {
        List<WebElement> rows = driver.findElements(TABLE_ROWS);
        rows.forEach(row -> {
            int salary = Integer.parseInt(row.findElement(SALARY_CELL).getAttribute("data-order"));
            int age = Integer.parseInt(row.findElement(AGE_CELL).getText());
            if (age > minAge && salary <= maxSalary) {
                String name = row.findElement(NAME_CELL).getText();
                String position = row.findElement(POSITION_CELL).getText();
                String office = row.findElement(OFFICE_CELL).getText();
                employees.add(new Employee(name, position, office));
            }
        });
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

}
