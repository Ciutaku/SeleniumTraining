package pages;

import dto.AddressBook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage {

    @FindBy(xpath = "//*[text() = 'Add New Address']")
    private WebElement addNewAddressButton;

    @FindBy(name = "street[]")
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
        hover(addNewAddressButton);
        addNewAddressButton.click();
        AddressBook addressBook = new AddressBook();
        firstStreetField.sendKeys(addressBook.getFirsStreet());
        cityField.sendKeys(addressBook.getCity());
        telephoneField.sendKeys(addressBook.getTelephoneNumber());
        zipCodeField.sendKeys(addressBook.getZipCode());
        Select stateDropDown = new Select(regionDropDownMenu);
        stateDropDown.selectByValue("1");
        hover(saveAddressButton);
        saveAddressButton.click();
    }

    public boolean isNewAddressAdded() {
        return newAddressConfirmation.isDisplayed();
    }
}
