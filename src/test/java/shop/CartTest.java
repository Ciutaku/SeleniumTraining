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

    private VirtualItem virtualItem;

    @BeforeEach
    @Tag("CartTests")
    void initItems() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("virtualItemName");
        virtualItem.setPrice(199.82);
        virtualItem.setSizeOnDisk(900);
        RealItem realItem = new RealItem();
        realItem.setName("realItemName");
        realItem.setPrice(199.82);
        realItem.setWeight(900);
        this.realItem = realItem;
        this.virtualItem = virtualItem;
    }

    @Test
    @Tag("CartTests")
    void testTotalPriceAfterAdditionToCart() {
        Cart cart = new Cart("testCart");
        cart.addRealItem(realItem);
        assertEquals(239.784, cart.getTotalPrice());
        cart.addVirtualItem(virtualItem);
        assertEquals(479.568, cart.getTotalPrice());
    }

    @Test
    @Tag("CartTests")
    void testTotalPriceAfterRemovingFromCart() {
        Cart cart = new Cart("testCart");
        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);
        assertEquals(479.568, cart.getTotalPrice());
        cart.deleteRealItem(realItem);
        assertEquals(239.784, cart.getTotalPrice());
        cart.deleteVirtualItem(virtualItem);
        assertEquals(0, cart.getTotalPrice());
    }
}