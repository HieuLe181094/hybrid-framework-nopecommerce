package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import commons.BrowserType;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver (String url, String browserName){
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());

        switch (browserName){
            case "edge" :
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected void closeBrowserDriver(){
        if (driver != null){
            driver.quit();
        }

    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }
}
