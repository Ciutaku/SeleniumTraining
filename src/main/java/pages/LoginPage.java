package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static final By LOGIN_FIELD = By.id("passp-field-login");
    private static final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final String URL = "https://passport.yandex.com/";

    public AccountPage logIn(String username, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(username);
        driver.findElement(SIGN_IN_BUTTON).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AccountPage();
    }

    public boolean isPassFieldDisplayed() {
        return driver.findElement(PASSWORD_FIELD).isDisplayed();
    }

    public void goToLogInPage() {
        driver.get(URL);
    }

}
