import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTests {

    private String password = "Tester123456!";
    private String homePage = "https://passport.yandex.com/";

    private final List<Employee> employeeList = new ArrayList<>();

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
        driver.get(homePage);
        driver.findElement(By.id("passp-field-login")).sendKeys(testName);
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(1000); //Thread.sleep is an implicit waiter
        driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
        driver.findElement(By.id("passp:sign-in")).click();
        driver.findElement(By.xpath("//*[@class='UserID-Avatar ']")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains (@class, 'Subname')]")))); //Tried multiple identifiers, could not manage to target element
        assertTrue(nameElement.isDisplayed());
    }

    @Test
    void multiSelectDemoTest() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement dropDownElement = driver.findElement(By.id("multi-select"));
        Select selector = new Select(dropDownElement);
        List<String> listOfOptions = new ArrayList<>();
        for (WebElement item : selector.getOptions())
            listOfOptions.add(item.getText());

        List<String> expectedSelectedOptionsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, listOfOptions.size() - 1);
            expectedSelectedOptionsList.add(listOfOptions.get(randomNumber));
        }
        for (String item : expectedSelectedOptionsList) {
            selector.selectByValue(item);
        }
        List<String> actualSelectedOptionsList = new ArrayList<>();
        for (WebElement selectedItem : selector.getAllSelectedOptions())
            actualSelectedOptionsList.add(selectedItem.getText());

        assertTrue(expectedSelectedOptionsList
                .size() == actualSelectedOptionsList
                .size() && actualSelectedOptionsList
                .containsAll(expectedSelectedOptionsList) && expectedSelectedOptionsList
                .containsAll(actualSelectedOptionsList));
    }

    @Test
    void testUserGenerated() {
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        driver.findElement(By.id("save")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@src, 'loader-image.gif')]")));
        WebElement portraitImage = driver.findElement(By.xpath("//*[contains(@src, '.jpg')]"));
        WebElement firstName = driver.findElement(By.xpath("//*[contains(text(), 'First')]"));
        WebElement lastName = driver.findElement(By.xpath("//*[contains(text(), 'Last')]"));
        assertAll("Verifies all elements are displayed",
                () -> assertTrue(portraitImage.isDisplayed()),
                () -> assertTrue(firstName.isDisplayed()),
                () -> assertTrue(lastName.isDisplayed()));
    }

    @Test
    void testRefreshOnReaching50Percent() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.findElement(By.id("cricle-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(text()='50%')]")));
        driver.navigate().refresh();

    }

    @Test
    void testTableSorter() {
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        WebElement tableElement = driver.findElement(By.xpath("//*[@id='example']"));
        List<WebElement> rowsElements = tableElement.findElements(By.xpath("//tr[@role='row']"));
        do {
            for (int i = 0; i < rowsElements.size() - 1; i++) {
                List<WebElement> nameRow = rowsElements.get(i).findElements(By.xpath("//td[1]"));
                List<WebElement> positionRow = rowsElements.get(i).findElements(By.xpath("//td[2]"));
                List<WebElement> officeRow = rowsElements.get(i).findElements(By.xpath("//td[3]"));
                List<WebElement> ageRow = rowsElements.get(i).findElements(By.xpath("//td[4]"));
                List<WebElement> salaryRow = rowsElements.get(i).findElements(By.xpath("//td[6]"));
                String ageRowString = ageRow.get(i).getText();
                String salaryRowString = salaryRow.get(i).getText().replaceAll("[$ , /y]", "");
                int ageRowInt = Integer.parseInt(ageRowString);
                int salaryRowInt = Integer.parseInt(salaryRowString);
                if (ageRowInt > 28 && salaryRowInt < 800000) {
                    Employee employee = new Employee();
                    employee.setName(nameRow.get(i).getText());
                    employee.setPosition(positionRow.get(i).getText());
                    employee.setOffice(officeRow.get(i).getText());
                    employeeList.add(employee);
                }
                driver.findElement(By.className("next")).click(); //Not sure if this is where it should happen
            }
            //For debugging purposes
            /*for (Employee employee : employeeList) {
                System.out.println(employee.getName());
                System.out.println(employee.getOffice());
                System.out.println(employee.getPosition());
            }
            System.out.println("Size of employeeList is " + employeeList.size());*/

        } while (!driver.findElement(By.xpath("//*[contains(@class, 'disabled')]")).isDisplayed());
        //If I use "do-while" approach, Stale element error occurs starting from first element in the first "for"
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

}
