package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WebDriverInit;

public class LoginPage {
    public final By LOGGED_OUT_TEXT = By.xpath("//*[contains (text(), 'Log in to contiue')]");
    private final By LOGIN_FIELD = By.id("passp-field-login");
    private final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    private final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final String USERNAME = "selenium.t";
    private final String PASSWORD = "Tester123456!";
    private final String URL = "https://passport.yandex.com/";
    private final WebDriver driver = WebDriverInit.getInstance();

    public void logInWithCredentials() {

        driver.findElement(LOGIN_FIELD).sendKeys(USERNAME);
        driver.findElement(SIGN_IN_BUTTON).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public boolean loggedOutTextDisplayed() {
        return driver.findElement(LOGGED_OUT_TEXT).isDisplayed();
    }

    public void goToLogInPage() {
        driver.get(URL);
    }

}
