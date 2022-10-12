package parser;

import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    private JsonParser parser;
    public static final String CART_NAME = "andrew-cart";

    @BeforeEach
    public void init() {
        parser = new JsonParser();
    }

    @Test
    void testWriteToFile() {
        parser.writeToFile(new Cart("testCartFile"));
        File testCartFile = new File("src/main/resources/testCartFile.json");
        assertTrue(testCartFile.exists());
    }

    @Test
    @Disabled
    void testReadFromFile() {
        String path = "src/main/resources/" + CART_NAME + ".json";
        Cart cart = parser.readFromFile(new File(path));
        Assertions.assertAll(
                () -> assertEquals(CART_NAME, cart.getCartName()),
                () -> assertEquals(38445.479999999996, cart.getTotalPrice()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"badfileone", "badfiletwo", "badfilethree", "badfilefour", "badfilefive"})
    public void testFileNotFoundException(String fileName) {
        final File nonExistingFile = new File(fileName);
        assertThrows(NoSuchFileException.class, () -> parser.readFromFile(nonExistingFile));
    }

    @AfterAll
    static void cleanUp() {
        File testCartFile = new File("src/main/resources/testCartFile.json");
        if (testCartFile.exists()) {
            testCartFile.delete();
        }
    }
}