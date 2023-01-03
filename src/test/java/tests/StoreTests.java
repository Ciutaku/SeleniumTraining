package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailPage;
import pages.HomePage;

import static tests.Const.*;

@Listeners(TestListener.class)
public class StoreTests extends BaseTest {

    @Test
    @AllureId("4")
    @Description("User goes to store and adds an item to wishlist")
    void goToClothesProductAndAddToWishlist() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        ProductDetailPage productDetailPage = homePage.goToWomenBottomClothesPage();
        productDetailPage.addAnItemToWishlist();
        Assert.assertTrue(productDetailPage.isSuccessMessageDisplayed()); //Assert may fail if account is not cleaned up from previous attempts, should not happen when using new accounts
    }

    @Test
    @AllureId("5")
    @Description("User adds 3 items from store to cart and checks total")
    void goToShopAndAddToCart() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        ProductDetailPage productDetailPage = homePage.goToWomenBottomClothesPage();
        productDetailPage.addItemsToCart(homePage, 3);
        CartPage cartPage = productDetailPage.goToMyCart();
        Assert.assertTrue(cartPage.isCorrectTotalPriceDisplayed()); //Assert fails if there are too many items, discount applied
    }
}


