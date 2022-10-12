package parser;

import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    @Tag("ParserTests")
    void testWriteToFile() {
        JsonParser parser = new JsonParser();
        parser.writeToFile(new Cart("testCartFile"));
        File testCartFile = new File("src/main/resources/testCartFile.json");
        assertTrue(testCartFile.exists());
    }

    @Test
    @Disabled
    @Tag("ParserTests")
    void testReadFromFile() {
        String expectedCartName ="predefinedCart";
        double expectedTotalPrice = 38445.479999999996;
        JsonParser parser = new JsonParser();
        File predefinedCart = new File("src/main/resources/predefinedCart.json");
        Cart cart = parser.readFromFile(predefinedCart);
        Assertions.assertAll("Return details of predefinedCart",
                () -> assertEquals(expectedCartName, cart.getCartName()),
                () -> assertEquals(expectedTotalPrice, cart.getTotalPrice()));
    }

    @ParameterizedTest
    @Tag("ParserTests")
    @ValueSource(strings = {"badfileone", "badfiletwo", "badfilethree", "badfilefour", "badfilefive"})
    public void testFileNotFoundException(String fileName) {
        JsonParser parser = new JsonParser();
        final File nonExistingFile = new File(fileName);
        assertThrows(NoSuchFileException.class, () -> parser.readFromFile(nonExistingFile));
    }

    @AfterAll
    @Tag("ParserTests")
    static void cleanUp() {
        File testCartFile = new File("src/main/resources/testCartFile.json");
        if (testCartFile.exists()) {
            testCartFile.delete();
        }
    }
}