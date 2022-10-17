package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class VirtualItemTest {

    private VirtualItem virtualTestItem;
    public static final double EXPECT_SIZE_ON_DISK = 90.00;

    @BeforeTest
    void prepareVirtualItemTestData() {
        virtualTestItem = new VirtualItem();
        virtualTestItem.setSizeOnDisk(EXPECT_SIZE_ON_DISK);
    }

    @Test(groups = {"VirtualItemGroup"})
    void testToStringSizeOnDisk() {
        Assert.assertTrue(virtualTestItem.toString().contains("Size on disk: " + EXPECT_SIZE_ON_DISK));
    }
}