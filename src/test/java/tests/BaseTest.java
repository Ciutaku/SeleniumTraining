package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.WebDriverInit;

public class BaseTest {

    @BeforeMethod
    void goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
    }

    @AfterMethod
    void tearDown() {
        WebDriverInit.cleanUp();
    }
}
