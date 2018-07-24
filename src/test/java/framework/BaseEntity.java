package framework;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BaseEntity {

    protected static WebDriver driver;

    protected static ConfigFileReader configFile = new ConfigFileReader();

    protected BaseEntity() {
    }

    protected static WebDriver getDriver() {
        return driver;
    }

    void assertTrue(boolean isTrue){
        Assert.assertTrue(isTrue);
    }

    public static void setUp() {

        driver = Browser.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(configFile.getConfigProperty("timeout")), TimeUnit.SECONDS);
        driver.get(configFile.getConfigProperty("url"));
        driver.manage().deleteAllCookies();

    }

    public static void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
