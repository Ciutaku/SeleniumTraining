package tests;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.WebDriverInit;

public class TestListener implements ITestListener {
    WebDriver driver = WebDriverInit.getChromeDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        java.util.Date date = new java.util.Date();
        Allure.attachment("Time of test failure is : ", String.valueOf(date));
        Allure.attachment("Browser Name is : ", ((RemoteWebDriver) driver).getCapabilities().getBrowserName());
        Allure.attachment("Browser Version is : ", ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());

    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverInit.getChromeDriver()).getScreenshotAs(OutputType.BYTES);
    }
}