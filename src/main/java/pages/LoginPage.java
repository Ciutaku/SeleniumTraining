package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy (id = "passp-field-login")
    public WebElement LOGIN_FIELD;
    @FindBy (id = "passp:sign-in" )
    public  WebElement SIGN_IN_BUTTON;
    @FindBy (id = "passp-field-passwd")
    public  WebElement PASSWORD_FIELD;
    public  static final String URL = "https://passport.yandex.com/";

    public LoginPage(){
        driver = WebDriverInit.getDriver();
        PageFactory.initElements(driver, this);
    }

    public AccountPage logIn(String username, String password) {
        LOGIN_FIELD.sendKeys(username);
        SIGN_IN_BUTTON.click();
        PASSWORD_FIELD.sendKeys(password);
        SIGN_IN_BUTTON.click();
        return new AccountPage();
    }

    public boolean isPassFieldDisplayed() {
        return PASSWORD_FIELD.isDisplayed();
    }

    public void goToLogInPage() {
        driver.get(URL);
    }

}
