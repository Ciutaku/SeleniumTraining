package shop;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    RealItem realItem = new RealItem();
    double testWeight = 90.00;
    double expectedTestWeight = 90.00;

    @Test
    @Tag("Items")
    void testGetWeight() {
        realItem.setWeight(testWeight);
        assertEquals(expectedTestWeight, realItem.getWeight());
    }
}