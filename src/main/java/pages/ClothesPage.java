package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ClothesPage extends BasePage {

    @FindBy(className = "product-item")
    private List<WebElement> product;

    @FindBy(xpath = "//span[text() = 'Add to Wish List']")
    private WebElement wishListButton;

    @FindBy(xpath = "//div[contains(text(), ' has been added to your Wish List.')]")
    private WebElement successMessage;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCart;

    @FindBy(className = "swatch-option")
    private WebElement sizeOption;

    @FindBy(xpath = "//div[contains (@id, 'option-label-color')]")
    private WebElement colorOption;

    private static final String CART_URL = "https://magento.softwaretestingboard.com/checkout/cart/";

    @FindBy(xpath = "counter-number")
    private WebElement cartAmount;

    @FindBy(xpath = "//*[@id='shopping-cart-table']/tbody/tr[1]/td[4]/span/span/span")
    private List<WebElement> productSubtTotalCartPrice;

    @FindBy(className = "grand")
    private WebElement orderTotal;

    Actions actions = new Actions(WebDriverInit.getChromeDriver());

    public ClothesPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addAnItemToWishlist() {
        clickOnARandomProduct();
        wishListButton.click();
    }

    public void clickOnARandomProduct() {
        Random random = new Random();
        WebElement randomProduct = product.get(random.nextInt(product.size() - 1));
        actions.moveToElement(randomProduct).click().perform();
    }
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isCorrectTotalPriceDisplayed() {
        double totalAmountExpected = 0;
        for (WebElement productPrice : productSubtTotalCartPrice) {
            double productDouble = Double.parseDouble(productPrice.getText().replaceAll("[,$]", ""));
            totalAmountExpected += productDouble;
        }
        return (totalAmountExpected == Double.parseDouble(orderTotal.getText().replaceAll("[A-Za-z,$]", "")));
    }

    public void addThreeDifferentItemsToCart(HomePage homePage) {
        for (int i = 0; i < 3; i++) {
            actions.moveToElement(product.get(i)).click().perform();
            sizeOption.click();
            colorOption.click();
            addToCart.click();
            homePage.goToWomenBottomClothesPage();
        }
    }

    public void goToMyCart() {
        driver.get(CART_URL);
    }
}