package shop;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualItemTest {

    private VirtualItem virtualTestItem;
    public static final double EXPECT_SIZE_ON_DISK = 90.00;

    @BeforeEach
    void prepareVirtualItemTestData() {
        virtualTestItem = new VirtualItem();
        virtualTestItem.setSizeOnDisk(EXPECT_SIZE_ON_DISK);
    }

    @Test
    void testToStringSizeOnDisk() {
        assertTrue(virtualTestItem.toString().contains("Size on disk: " + EXPECT_SIZE_ON_DISK));
    }
}