package environmentFactory;

import browserFactory.*;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LocalEnvironmentManager implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalEnvironmentManager(WebDriver driver, String browserName) {
        this.driver = driver;
        this.browserName = browserName;
    }

    @Override
    public WebDriver createDriver() {
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        switch (browserType){
            case FIREFOX:
                driver = new FirefoxBrowserManager().getDriver();
                break;
            case HFIREFOX:
                driver = new FirefoxHeadlessBrowserManager().getDriver();
                break;

            case CHROME:
                driver = new ChromeBrowserManager().getDriver();
                break;
            case HCHROME:
                driver = new ChromeHeadlessBrowserManager().getDriver();
                break;

            case COCCOC:
                driver = new CocCocBrowserManager().getDriver();
                break;

            case IE:
                driver = new IEBrowserManager().getDriver();
                break;

            case SAFARI:
                driver = new SafariBrowserManager().getDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser name is not valid");
        }

        return driver;
    }
}
