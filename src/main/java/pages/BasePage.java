package pages;


import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverInit.getChromeDriver();
    }
}
