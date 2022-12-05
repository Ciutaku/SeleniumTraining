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
    private static final String SCREENSHOT_FOLDER_PATH = "/Users/costicadragu/Desktop/screenshots/";

    @BeforeEach
    void goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
    }

    @AfterEach
    void tearDown() {
        WebDriverInit.cleanUp();
    }

    public void takeScreenshot(String screenshotName) {
        try {
            File scrFile =
                    ((TakesScreenshot) WebDriverInit.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(SCREENSHOT_FOLDER_PATH + screenshotName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
