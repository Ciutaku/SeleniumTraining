package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

class CartTest {

    private RealItem realItem;
    private Cart cart;

    @BeforeTest
    void initTestData() {
        cart = new Cart("testCart");
        realItem = new RealItem();
        realItem.setPrice(100);
        cart.addRealItem(realItem);
    }

    @Test(groups = {"CartGroup"})
    void testCalculationAfterAddingRealItemToCart() {
        Assert.assertEquals(120.0, cart.getTotalPrice());
    }

    @Test(groups = {"CartGroup"})
    void testCalculationAfterRemovingRealItemFromCart() {
        cart.deleteRealItem(realItem);
        Assert.assertEquals(0, cart.getTotalPrice());
    }
}