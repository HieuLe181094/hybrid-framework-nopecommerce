package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeTabs {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
