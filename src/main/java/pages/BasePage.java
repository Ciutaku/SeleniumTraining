package pages;


import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }

    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}
