package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddressBookPage;
import pages.HomePage;

@Listeners(TestListener.class)
public class AddressBookTest extends BaseTest {

    private static final String EMAIL = "task160email@gmail.com";
    private static final String PASSWORD = "Tester123";

    @Test
    @AllureId("3")
    @Description("User goes to address page and adds a valid address")
    void goToAddressBookAndAddAddress() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        AddressBookPage addressBookPage = homePage.goToAddressBook();
        addressBookPage.addNewAddress();
        Assert.assertTrue(addressBookPage.isNewAddressAdded());
    }
}


