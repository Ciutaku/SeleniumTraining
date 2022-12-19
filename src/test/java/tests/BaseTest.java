package tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.WebDriverInit;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static tests.Config.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        switch (HOST) {
            case "saucelabs": {
                MutableCapabilities sauceOptions = new MutableCapabilities();
                String sauceURL = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
                sauceOptions.setCapability("username", SAUCE_USER);
                sauceOptions.setCapability("access_key", SAUCE_KEY);
                sauceOptions.setCapability("name", method.getName());
                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability("browserName", BROWSER_NAME);
                capabilities.setCapability("browserVersion", BROWSER_VERSION);
                capabilities.setCapability("platformName", PLATFORM_NAME);
                capabilities.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
                break;
            }
            case "localhost": {
                if ("firefox".equals(BROWSER_NAME)) {
                    driver = WebDriverInit.getFirefoxDriver();
                }
                if ("chrome".equals(BROWSER_NAME)) {
                    driver = WebDriverInit.getChromeDriver();
                }
                break;
            }
        }
        goToHomePage();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (HOST.equals("saucelabs")) {
            //Needs RemoteWebDriver I think, but wasn't able resolve it so commented out so I can at least run local
            String status = result.isSuccess() ? "passed" : "failed";
            // driver.executeScript("sauce:job-result=" + status);
        } else {
            WebDriverInit.cleanUp();
        }
    }
    public void goToHomePage(){
        HomePage homePage = new HomePage();
        homePage.goToHomePage();
    }
}
