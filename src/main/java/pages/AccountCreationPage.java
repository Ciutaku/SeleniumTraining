package pages;

import dto.User;
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

    private static final String URL = "https://magento.softwaretestingboard.com/customer/account/create/";


    public AccountCreationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage fillInAllDetailsAndCreateAccount() {
        User user = new User();
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailAddressField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
        createAnAccountButton.click();
        return new MyAccountPage();
    }

    public void goToAccountCreationPage() {
        driver.get(URL);
    }

}
