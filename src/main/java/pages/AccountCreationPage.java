package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailAddressField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(className = "submit")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//div[text() ='Thank you for registering with Fake Online Clothing Store.']")
    private WebElement successfulRegistrationMessage;

    private static final String URL = "https://magento.softwaretestingboard.com/customer/account/create/";

    private static final String FIRSTNAME = TestUtils.generateRandomAlphabetString(5);
    private static final String LASTNAME = TestUtils.generateRandomAlphabetString(8);
    private static final String RANDOM_EMAIL = "randomgmail+" + TestUtils.generateRandomAlphaNumericString(15) + "@gmail.com";
    private static final String PASSWORD = TestUtils.generateRandomAlphaNumericString(15);

    public AccountCreationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void fillInAllDetailsAndCreateAccount() {
        driver.get(URL);
        firstNameField.sendKeys(FIRSTNAME);
        lastNameField.sendKeys(LASTNAME);
        emailAddressField.sendKeys(RANDOM_EMAIL);
        passwordField.sendKeys(PASSWORD);
        confirmPasswordField.sendKeys(PASSWORD);
        createAnAccountButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successfulRegistrationMessage.isDisplayed();
    }

}
