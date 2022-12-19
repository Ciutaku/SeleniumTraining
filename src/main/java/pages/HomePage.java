package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains (text(), 'Sign In ')]")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement loginButton;

    private static final String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";
    private static final String ADDRESS_BOOK_URL = "https://magento.softwaretestingboard.com/customer/address/index/";
    private static final String WOMEN_BOTTOM_CLOTHES_URL = "https://magento.softwaretestingboard.com/women/bottoms-women.html";
    @FindBy(xpath = "//span[text() = 'Welcome, test account!']")
    private WebElement welcomeMessage;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public AddressBookPage goToAddressBook() {
        driver.get(ADDRESS_BOOK_URL);
        return new AddressBookPage();
    }

    public ClothesPage goToWomenBottomClothesPage() {
        driver.get(WOMEN_BOTTOM_CLOTHES_URL);
        return new ClothesPage();
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
}
