package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailPage;

import static helper.Const.*;

@Listeners(TestListener.class)
public class StoreTests extends BaseTest {

    @BeforeMethod
    public void initialLogin() {
        homePage.logIn(EMAIL, PASSWORD);
    }

    @Test
    @AllureId("4")
    @Description("User goes to store and adds an item to wishlist")
    void goToClothesProductAndAddToWishlist() {
        ProductDetailPage productDetailPage = homePage.getHeader()
                .chooseMenu(WOMEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY);
        productDetailPage.addAnItemToWishlist();
        Assert.assertTrue(productDetailPage.isSuccessMessageDisplayed()); //Assert may fail if account is not cleaned up from previous attempts, should not happen when using new accounts
    }

    @Test
    @AllureId("5")
    @Description("User adds 3 items from store to cart and checks total")
    void goToShopAndAddToCart() {
        ProductDetailPage productDetailPage = homePage.getHeader()
                .chooseMenu(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, SHORTS_SUB_CATEGORY);
        productDetailPage.addItemsToCart(3);
        CartPage cartPage = productDetailPage.goToMyCart();
        Assert.assertTrue(cartPage.isCorrectTotalPriceDisplayed()); //Assert fails if there are too many items, discount applied
    }
}


