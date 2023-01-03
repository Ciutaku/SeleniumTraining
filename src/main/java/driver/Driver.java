package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static driver.Config.*;

public class Driver {

    // 'mvn clean -Dbrowser=firefox test ' command line contains a parameter  for determining the browser type. The
    // same for remote:  '-Dremote=http://test:test-password@GRID-HOST:4444/wd/hub'

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        MutableCapabilities capabilities = BrowserCapabilities.getBrowserCapabilities(BROWSER_NAME);
        if (!StringUtils.isNullOrEmpty(REMOTE_URL)) {
            return getRemoteDriver();
        }
        return getLocalDriver(capabilities);
    }

    private static WebDriver getRemoteDriver() {
        try {
            return new RemoteWebDriver(new URL(REMOTE_URL), BrowserCapabilities.getCloudCapabilities());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid 'remote' parameter: " + REMOTE_URL, e);
        }
    }

    private static WebDriver getLocalDriver(Capabilities capabilities) {
        switch (BROWSER_NAME) {
            case "chrome": {
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                return new ChromeDriver((ChromeOptions) Objects.requireNonNull(capabilities));
            }
            case "firefox": {
                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                return new FirefoxDriver((FirefoxOptions) Objects.requireNonNull(capabilities));
            }
            default:
                throw new RuntimeException("Please check your browser name");
        }
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
