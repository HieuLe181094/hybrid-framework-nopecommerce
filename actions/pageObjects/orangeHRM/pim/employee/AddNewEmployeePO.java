package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import dataOrangeHRM.EmployeeInfor;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewPIM_UI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewPIM_UI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPIM_UI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewPIM_UI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPIM_UI.LASTNAME_TEXTBOX, lastName);
    }

    public PersonalDetailsPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementVisible(driver,AddNewPIM_UI.SAVE_BUTTON);
        clickToElement(driver, AddNewPIM_UI.SAVE_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public void enterToAddNewEmployeeForm(EmployeeInfor employeeInfor) {
        enterToFirstNameTextbox(employeeInfor.getFirstName());
        enterToLastNameTextbox(employeeInfor.getLastName());
    }
}
