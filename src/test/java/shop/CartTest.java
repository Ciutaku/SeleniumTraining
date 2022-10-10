package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private String cartName = "testCart";
    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;


    @BeforeEach
    @Tag("CartTests")
    void initCart() {
        this.cart = new Cart(cartName);
    }

    @Test
    @Tag("CartTests")
    void addRealItem() {
        realItem.setName("realItemName");
        realItem.setPrice(199);
        realItem.setWeight(900);
        cart.addRealItem(realItem);
        Assertions.assertAll("Should return all set details from real item within the cart",
                () -> assertEquals("realItemName", ),
                () -> assertEquals("199", ),
                () -> assertEquals("900", );
    }

    @Test
    @Tag("CartTests")
    void addVirtualItem() {
        virtualItem.setName("virtualItemName");
        virtualItem.setPrice(99);
        virtualItem.setSizeOnDisk(8000);
        cart.addVirtualItem(virtualItem);
    }

    @After
    @Tag("CartTests")
    void cleanUp() {
        cart.deleteRealItem(realItem);
        cart.deleteVirtualItem(virtualItem);
    }

}