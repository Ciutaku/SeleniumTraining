import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    WebDriver driver = new ChromeDriver();

    @Test
    void locatorsExamples() {
        driver.get("https://passport.yandex.com/");
        driver.findElement(By.id("passp-field-login"));
        driver.findElement(By.name("login"));
        driver.findElement(By.className("Logo"));
        driver.findElement(By.tagName("button"));
        driver.findElement(By.linkText("I forgot"));
        driver.findElement(By.partialLinkText("Learn"));
        driver.findElement(By.cssSelector("input[type='text']"));
        driver.findElement(By.xpath("//button[text()='Create ID']"));
    }
}
