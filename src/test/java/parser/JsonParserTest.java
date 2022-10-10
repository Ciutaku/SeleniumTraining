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
        JsonParser parser = new JsonParser();
        File predefinedCart = new File("src/main/resources/predefinedCart.json");
        parser.readFromFile(predefinedCart);
    }

    @ParameterizedTest
    @Tag("ParserTests")
    @ValueSource(strings = {"badfileone", "badfiletwo","badfilethree", "badfilefour", "badfilefive"})
    public void testFileNotFoundException(String fileName) {
        JsonParser parser = new JsonParser();
        final File nonExistingFile = new File(fileName);
        Throwable exception = assertThrows(NoSuchFileException.class, () -> parser.readFromFile(nonExistingFile));

    }
    @AfterAll
    @Tag("ParserTests")
    static void cleanUp() {
        File testCartFile = new File("src/main/resources/testCartFile.json");
        if(testCartFile.exists()) {
            testCartFile.delete();
        }
    }

}