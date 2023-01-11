package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.MyAccountPage;

@Listeners(TestListener.class)
public class AccountCreationTest extends BaseTest {

    @Test
    @AllureId("1")
    @Description("User creates an account successfully")
    void createAccount() {
        AccountCreationPage accountCreationPage = new AccountCreationPage();
        accountCreationPage.goToAccountCreationPage();
        MyAccountPage myAccountPage = accountCreationPage.fillInAllDetailsAndCreateAccount();
        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }
}


