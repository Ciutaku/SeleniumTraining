package driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static driver.Config.*;

public class BrowserCapabilities {

    public static MutableCapabilities getBrowserCapabilities(String BROWSER_NAME) {
        switch (BROWSER_NAME) {
            case "chrome":
                return getChromeCapabilities();
            case "firefox":
                return getFirefoxCapabilities();
            default:
                throw new RuntimeException("getBrowserCapabilities: Please check your browser name");
        }
    }

    private static MutableCapabilities getFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static MutableCapabilities getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    public static Capabilities getCloudCapabilities() {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", SAUCE_USER);
        sauceOptions.setCapability("access_key", SAUCE_KEY);
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", BROWSER_NAME);
        capabilities.setCapability("browserVersion", BROWSER_VERSION);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("sauce:options", sauceOptions);
        return capabilities;
    }
}