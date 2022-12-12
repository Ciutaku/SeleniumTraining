package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import pages.WebDriverInit;

import java.io.File;

public class BaseTest {

    @BeforeEach
    void goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
    }

    @AfterEach
    void tearDown() {
        WebDriverInit.cleanUp();
    }
}
