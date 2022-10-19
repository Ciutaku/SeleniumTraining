package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RealItemTest {

    private RealItem realTestItem;
    public static final double EXPECT_WEIGHT = 90.00;

    @BeforeTest
    void prepareRealItemTestData() {
        realTestItem = new RealItem();
        realTestItem.setWeight(EXPECT_WEIGHT);
    }

    @Test(groups = {"RealItemGroup"})
    void testToStringWeight() {
        Assert.assertTrue(realTestItem.toString().contains("Weight: " + EXPECT_WEIGHT));
    }
}