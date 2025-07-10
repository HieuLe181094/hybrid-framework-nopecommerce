package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.*;
import pageObjects.orangeHRM.pim.reports.AddNewReportPO;
import pageObjects.orangeHRM.pim.reports.ReportSearchPO;

import java.lang.reflect.Constructor;

public class PageGenerator {
    public static <T extends BasePage> T getPageInstance(Class<T> pageClass, WebDriver driver){
        try {
            // Lấy constructor nhận WebDriver
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            // Tạo instance mới của page class
            return constructor.newInstance(driver);
        } catch (Exception e){
            throw new RuntimeException("Can not init page class" + pageClass.getSimpleName(),e);
        }
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }

    public static AddNewReportPO getAddNewReportPage(WebDriver driver){
        return new AddNewReportPO(driver);
    }

    public static ReportSearchPO getReportSearchPage(WebDriver driver){
        return new ReportSearchPO(driver);
    }

    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver){
        return new AddNewEmployeePO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage(WebDriver driver){
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver){
        return new EmergencyContactsPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return new EmployeeListPO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver){
        return new PersonalDetailsPO(driver);
    }

}
