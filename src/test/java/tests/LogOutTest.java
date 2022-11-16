package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogOutTest {
    WebDriver driver = WebDriverInit.getInstance();

    @Test
    void logOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
        loginPage.logInWithCredentials();
        HomePage homePage = new HomePage();
        homePage.clickAvatarButton();
        homePage.switchToIframe(1);
        homePage.signOut();
        loginPage.switchToDefaultContent(); //does not refocus on webpage after logging out
        assertTrue(loginPage.loggedOutTextDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
