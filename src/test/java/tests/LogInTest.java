package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import static tests.Const.*;

@Listeners(TestListener.class)
public class LogInTest extends BaseTest {

    @Test
    @AllureId("2")
    @Description("User goes to homepage and logs in using valid credentials")
    void goToHomePageAndLogIn() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
    }
}


