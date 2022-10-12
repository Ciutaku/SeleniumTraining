package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private RealItem realItem;
    private Cart cart;

    @BeforeEach
    void initTestData() {
        cart = new Cart("testCart");
        realItem = new RealItem();
        realItem.setPrice(100);
        cart.addRealItem(realItem);
    }

    @Test
    void testCalculationAfterAddingRealItemToCart() {
        assertEquals(120.0, cart.getTotalPrice());
    }

    @Test
    void testCalculationAfterRemovingRealItemFromCart() {
        cart.deleteRealItem(realItem);
        assertEquals(0, cart.getTotalPrice());
    }
}