package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.pim.employee.*;
import pageObjects.orangeHRM.pim.reports.AddNewReportPO;
import pageObjects.orangeHRM.pim.reports.ReportSearchPO;

import java.lang.reflect.Constructor;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static InventoryPageObject getInventoryPage(WebDriver driver){
        return new InventoryPageObject(driver);
    }
}
