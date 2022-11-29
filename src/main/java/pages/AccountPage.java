package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
    @FindBy(className = "Logout")
    private WebElement signOutButton;

    @FindBy(className = "UserID-Account")
    private WebElement avatarButton;

    public AccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickAvatarButton() {
        avatarButton.click();
    }

    public boolean isAvatarDisplayed() {
        return avatarButton.isDisplayed();
    }

    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }

    public void signOut() {
        switchToIframe(0);
        signOutButton.click();
        driver.switchTo().defaultContent();
    }
}
