package tests;

public class Config {
    public static final String BASE_URL = System.getProperty("baseUrl", "https://magento.softwaretestingboard.com/");
    public static final String HOST = System.getProperty("host","local");
    public static final String BROWSER_NAME = System.getProperty("browserName", "chrome");
    public static final String BROWSER_VERSION = System.getProperty("browserVersion","latest");
    public static final String PLATFORM_NAME = System.getProperty("platformName","Windows 10");
    public static final String SAUCE_USER = System.getenv("SAUCE_USERNAME");
    public static final String SAUCE_KEY = System.getenv("SAUCE_ACCESS_KEY");

}
