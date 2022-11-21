package tests;

import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.BaseTest;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogInTest extends BaseTest {

    private static final String USERNAME = "selenium.t";
    private static final String PASSWORD = "Tester123456!";

    @Test
    void goToLoginPageAndLogIn() {
        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = loginPage.logIn(USERNAME, PASSWORD);
        assertTrue(accountPage.isAvatarDisplayed());
    }
}


