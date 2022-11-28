package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void goToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogInPage();
    }
    @AfterEach
    void tearDown() {
        WebDriverInit.cleanUp();
    }

}
