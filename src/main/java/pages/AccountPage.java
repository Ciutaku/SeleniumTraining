package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    public static final By SUBNAME = By.className("Subname");
    public static final By SIGN_OUT_BUTTON = By.className("Logout");
    public static final By AVATAR_BUTTON = By.className("UserID-Account");

    public void clickAvatarButton() { driver.findElement(AVATAR_BUTTON).click(); }

    public boolean isDisplayedSubname() {
        return driver.findElement(SUBNAME).isDisplayed();
    }

    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }

    public void signOut() {
        switchToIframe(1);
        driver.findElement(SIGN_OUT_BUTTON).click();
        driver.switchTo().defaultContent();
    }
}
