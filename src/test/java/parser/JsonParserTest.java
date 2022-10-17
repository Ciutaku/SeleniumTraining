package parser;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import shop.Cart;

import java.io.*;

import static org.testng.Assert.*;


class JsonParserTest {

    private JsonParser parser;
    public static final String CART_NAME = "andrew-cart";
    @DataProvider(name = "badFilePaths")
    public Object[][]createData1() {
        return new Object[][] {
                { "badfileone"},
                { "badfiletwo"},
                { "badfilethree"},
                { "badfilefour"},
                { "badfilefive"},
        };
    }


    @BeforeTest
    public void init() {
        parser = new JsonParser();
    }

    @Parameters("CartFileName")
    @Test(groups = {"JsonParserGroup"})
    void testWriteToFile(String cartName) {
        parser.writeToFile(new Cart(cartName));
        File testCartFile = new File("src/main/resources/" + cartName + ".json");
        assertTrue(testCartFile.exists());
    }

    @Test(groups = {"JsonParserGroup", "brokenTest"})
    void testReadFromFile() {
        SoftAssert softAssert = new SoftAssert();
        String path = "src/main/resources/" + CART_NAME + ".json";
        Cart cart = parser.readFromFile(new File(path));
        softAssert.assertEquals(CART_NAME, cart.getCartName());
        softAssert.assertEquals(38445.479999999996, cart.getTotalPrice());
        softAssert.assertAll();
    }


    @Test (dataProvider = "badFilePaths")
    public void testFileNotFoundException(String fileName) {
        final File nonExistingFile = new File(fileName);
        assertThrows(NoSuchFileException.class, () -> parser.readFromFile(nonExistingFile));
    }

    @AfterTest
    static void cleanUp() {
        File testCartFile = new File("src/main/resources/testCartFile.json");
        if (testCartFile.exists()) {
            testCartFile.delete();
        }
    }
}