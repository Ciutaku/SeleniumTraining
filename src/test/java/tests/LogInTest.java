package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInTest {
    private final WebDriver driver = WebDriverInit.getInstance();


    @Test
    void goToLoginPageAndLogIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
        loginPage.logInWithCredentials();
        HomePage homePage = new HomePage();
        homePage.clickAvatarButton();
        homePage.switchToIframe(0);
        assertTrue(homePage.subNameTextDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


