package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {

    private Header header;

    @FindBy(xpath = "//a[contains (text(), 'Sign In ')]")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(xpath = "//span[text() = 'Women']")
    private WebElement womenTab;

    @FindBy(xpath = "//span[text() = 'Bottoms']")
    private WebElement bottomsButton;

    @FindBy(xpath = "//span[text() = 'Shorts']")
    private WebElement shortsButton;

    @FindBy(xpath = "//*[contains (@data-action, 'customer-menu-toggle')]")
    private WebElement customerMenuToggle;

    @FindBy(xpath = "//a[text() = 'My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//span[text() = 'Welcome, test account!']")
    private WebElement welcomeMessage;

    public static final String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return new Header();
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public AddressBookPage goToAddressBook() {
        clickCustomerArrow();
        myAccountButton.click();
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.clickAddressBookButton();
        return new AddressBookPage();
    }

    public void logIn(String username, String password) {
        signInButton.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void goToHomePage() {
        driver.get(HOMEPAGE_URL);
    }

    public void clickCustomerArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(customerMenuToggle)); //Needs specific wait time, couldn't find a way around it
        customerMenuToggle.click();
    }

}
