package shop;

import org.junit.Before;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {
    VirtualItem virtualItem = new VirtualItem();
    double testSize = 90.00;
    double expectedTestSize = 90.00;

    @Test
    @Tag("Items")
    void testGetSizeOnDisk() {
        virtualItem.setSizeOnDisk(testSize);
       assertEquals(expectedTestSize, virtualItem.getSizeOnDisk());
    }
}