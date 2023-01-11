package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
    @FindBy(css = ".message-success")
    private WebElement successfulRegistrationMessage;

    @FindBy(xpath = "//a[text() = 'My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[text() = 'Address Book']")
    private WebElement addressBookButton;

    public MyAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickAddressBookButton() {
        addressBookButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successfulRegistrationMessage.isDisplayed();
    }
}
