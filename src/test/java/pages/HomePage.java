package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WebDriverInit;

import java.util.List;

public class HomePage {
    public final By SUBNAME = By.className("Subname");
    public final By SIGN_OUT_BUTTON = By.className("Logout");
    public final By AVATAR_BUTTON = By.className("UserID-Account");
    WebDriver driver = WebDriverInit.getInstance();

    public void clickAvatarButton() {
        driver.findElement(AVATAR_BUTTON).click();
    }

    public boolean subNameTextDisplayed() {
        return driver.findElement(SUBNAME).isDisplayed();
    }

    public void switchToIframe(int iframeIndex) {
        driver.switchTo().frame(iframeIndex);
    }

    public void signOut() {
        driver.findElement(SIGN_OUT_BUTTON).click();
    }
}
