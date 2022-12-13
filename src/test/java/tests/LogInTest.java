package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

    private static final String USERNAME = "selenium.t";
    private static final String PASSWORD = "Tester123456!!";

    @Test
    @AllureId("1")
    @Description("User goes to login page and logs in using valid credentials")
    void goToLoginPageAndLogIn() {
        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = loginPage.logIn(USERNAME, PASSWORD);
        Assert.assertTrue(accountPage.isAvatarDisplayed());
    }

    @Test
    @AllureId("2")
    @Description("User logs in and then logs out")
    void logOut() {
        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = loginPage.logIn(USERNAME, PASSWORD);
        accountPage.clickAvatarButton();
        accountPage.signOut();
        Assert.assertTrue(loginPage.isPassFieldDisplayed());
    }
}


