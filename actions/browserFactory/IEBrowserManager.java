package browserFactory;

import commons.GlobalConstants;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        if (GlobalConstants.OS_NAME.contains("Windows")){
           throw new BrowserNotSupportedException("Internet Explore is not supported" + GlobalConstants.OS_NAME);
        }
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.destructivelyEnsureCleanSession();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        return new InternetExplorerDriver(ieOptions);
    }
}
