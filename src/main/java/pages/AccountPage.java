package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{
    @FindBy (className = "Logout")
    public WebElement SIGN_OUT_BUTTON;
    @FindBy (className = "UserID-Account")
    public WebElement AVATAR_BUTTON ;

    public AccountPage(){
        driver = WebDriverInit.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickAvatarButton() { AVATAR_BUTTON.click(); }

    public boolean isAvatarDisplayed() { return AVATAR_BUTTON.isDisplayed();}

    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }

    public void signOut() {
        switchToIframe(0);
        SIGN_OUT_BUTTON.click();
        driver.switchTo().defaultContent();
    }
}
