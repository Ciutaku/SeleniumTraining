package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage {

    @FindBy(className= "add")
    private WebElement addNewAddressButton;

    @FindBy(id = "street_1")
    private WebElement firstStreetField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement regionDropDownMenu;

    @FindBy(id = "zip")
    private WebElement zipCodeField;

    @FindBy(id = "telephone")
    private WebElement telephoneField;

    @FindBy(className = "save")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//div[text() = 'You saved the address.']")
    private WebElement newAddressConfirmation;

    public AddressBookPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addNewAddressButton);
        actions.perform();
        addNewAddressButton.click();
        firstStreetField.sendKeys(TestUtils.generateRandomAlphaNumericString(12));
        cityField.sendKeys(TestUtils.generateRandomAlphabetString(9));
        telephoneField.sendKeys(TestUtils.generateRandomNumericString(6));
        zipCodeField.sendKeys(TestUtils.generateRandomNumericString(6));
        Select stateDropDown = new Select(regionDropDownMenu);
        stateDropDown.selectByValue("1");
        actions.moveToElement(saveAddressButton);
        actions.perform();
        saveAddressButton.click();
    }

    public boolean isNewAddressAdded() {
        return newAddressConfirmation.isDisplayed();
    }
}
