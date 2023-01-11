package driver;

public class Config {

    public static final String REMOTE_URL = System.getProperty("remote");
    public static final String BROWSER_NAME = System.getProperty("browser");
    public static final String BROWSER_VERSION = System.getProperty("browserVersion");
    public static final String PLATFORM_NAME = System.getProperty("platformName");
    public static final String SAUCE_USER = System.getProperty("sauce_username");
    public static final String SAUCE_KEY = System.getProperty("sauce_access_key");

}
