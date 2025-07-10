package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewPIM_UI;
import pageUIs.orangeHRM.pim.employee.EmployeeListPIM_UI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeLink(){
        waitForElementVisible(driver, EmployeeListPIM_UI.ADD_NEW_EMPLOYEE_LINK);
        clickToElement(driver, EmployeeListPIM_UI.ADD_NEW_EMPLOYEE_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
