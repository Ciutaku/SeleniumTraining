package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(id = "passp:sign-in")
    private WebElement signInButton;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    private static final String URL = "https://passport.yandex.com/";

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public AccountPage logIn(String username, String password) {
        loginField.sendKeys(username);
        signInButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
        return new AccountPage();
    }

    public boolean isPassFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public void goToLogInPage() {
        driver.get(URL);
    }

}
