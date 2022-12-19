package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ClothesPage;
import pages.HomePage;

@Listeners(TestListener.class)
public class StoreTests extends BaseTest {

    private static final String EMAIL = "task160email@gmail.com";
    private static final String PASSWORD = "Tester123";

    @Test
    @AllureId("4")
    @Description("User goes to store and adds an item to wishlist")
    void goToClothesProductAndAddToWishlist() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        ClothesPage clothesPage = homePage.goToWomenBottomClothesPage();
        clothesPage.addAnItemToWishlist();
        Assert.assertTrue(clothesPage.isSuccessMessageDisplayed()); //Assert may fail if account is not cleaned up from previous attempts, should not happen when using new accounts
    }

    @Test
    @AllureId("5")
    @Description("User adds 3 items from store to cart and checks total")
    void goToShopAndAddToCart() {
        HomePage homePage = new HomePage();
        homePage.logIn(EMAIL, PASSWORD);
        ClothesPage clothesPage = homePage.goToWomenBottomClothesPage();
        clothesPage.addThreeDifferentItemsToCart(homePage);
        clothesPage.goToMyCart();
        Assert.assertTrue(clothesPage.isCorrectTotalPriceDisplayed()); //Assert fails if there are too many items, discount applied
    }
}


