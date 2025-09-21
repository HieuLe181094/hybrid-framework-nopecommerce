package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        if (GlobalConstants.OS_NAME.contains("MAC")){
            throw new BrowserNotSupportedException("Safari is not supported" + GlobalConstants.OS_NAME);
        }
        SafariOptions sOptions = new SafariOptions();
        return new SafariDriver(sOptions);
    }
}
