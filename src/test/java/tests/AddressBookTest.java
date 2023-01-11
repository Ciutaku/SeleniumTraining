package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddressBookPage;

import static helper.Const.*;

@Listeners(TestListener.class)
public class AddressBookTest extends BaseTest {

    @Test
    @AllureId("3")
    @Description("User goes to address page and adds a valid address")
    void goToAddressBookAndAddAddress() {
        homePage.logIn(EMAIL, PASSWORD);
        AddressBookPage addressBookPage = homePage.goToAddressBook();
        addressBookPage.addNewAddress();
        Assert.assertTrue(addressBookPage.isNewAddressAdded());
    }
}


