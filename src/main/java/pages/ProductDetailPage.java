package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".product-items .product-item")
    private List<WebElement> product;

    @FindBy(css = ".towishlist")
    private WebElement wishListButton;

    @FindBy(css = ".message-success")
    private WebElement successMessage;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCart;

    @FindBy(className = "swatch-option")
    private WebElement sizeOption;

    @FindBy(xpath = "//div[contains (@id, 'option-label-color')]")
    private WebElement colorOption;

    @FindBy(xpath = "counter-number")
    private WebElement cartAmount;

    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtTotalCartPrice;

    @FindBy(css = ".grand .price")
    private WebElement orderTotal;

    private static final String CART_URL = "https://magento.softwaretestingboard.com/checkout/cart/";

    public ProductDetailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addAnItemToWishlist() {
        clickOnARandomProduct();
        wishListButton.click();
    }

    public void clickOnARandomProduct() {
        Random random = new Random();
        Actions actions = new Actions(driver);
        WebElement randomProduct = product.get(random.nextInt(product.size() - 1));
        actions.moveToElement(randomProduct).click().perform();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public void addItemsToCart(HomePage homePage, int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            product.get(i).click();
            sizeOption.click();
            colorOption.click();
            addToCart.click();
            homePage.goToWomenBottomClothesPage();
        }
    }

    public CartPage goToMyCart() {
        driver.get(CART_URL); //Need to use direct URL instead of clicking cart, as it does not update itself with added items possibly due to caching
        return new CartPage();
    }
}