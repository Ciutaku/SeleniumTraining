package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import driver.Driver;

import java.time.Duration;


public class BaseTest {

    protected HomePage homePage;

    @BeforeMethod
    public void setup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        goToHomePage();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        Driver.tearDown();
    }

    private void goToHomePage() {
        homePage = new HomePage();
        homePage.goToHomePage();
    }
}
