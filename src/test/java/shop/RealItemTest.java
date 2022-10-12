package shop;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RealItemTest {

    private RealItem realTestItem;
    public static final double EXPECT_WEIGHT = 90.00;

    @BeforeEach
    void prepareRealItemTestData() {
        realTestItem = new RealItem();
        realTestItem.setWeight(EXPECT_WEIGHT);
    }

    @Test
    void testToStringWeight() {
        assertTrue(realTestItem.toString().contains("Weight: " + EXPECT_WEIGHT));
    }
}