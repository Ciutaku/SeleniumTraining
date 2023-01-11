package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtTotalCartPrice;

    @FindBy(css = ".grand .price")
    private WebElement orderTotal;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isCorrectTotalPriceDisplayed() {
        double totalAmountExpected = 0;
        for (WebElement productPrice : productSubtTotalCartPrice) {
            double productDouble = Double.parseDouble(productPrice.getText().replaceAll("[,$]", ""));
            totalAmountExpected += productDouble;
        }
        return (totalAmountExpected == Double.parseDouble(orderTotal.getText().replaceAll("[A-Za-z,$]", "")));
    }
}
