package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

public class Browser extends BaseEntity{

    private static WebDriver driver;
    private static Browser instance;
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static String browser = getParameter("browser");

    private static final String chromeDriverPath = "./src/test/resources/chromedriver";
    private static final String geckoDriverPath = "./src/test/resources/geckodriver";

    private Browser(){}

    private static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        String pathChrome = null;
        try {
            pathChrome = String.valueOf(new File(chromeDriverPath).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathGecko = null;
        try {
            pathGecko = String.valueOf(new File(geckoDriverPath).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (OS){
            case "windows 10":
                pathChrome = String.format("%s.exe", pathChrome);
                pathGecko = String.format("%s.exe", pathGecko);
                break;
            case "linux":
                break;
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", pathChrome);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", pathGecko);
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

}
