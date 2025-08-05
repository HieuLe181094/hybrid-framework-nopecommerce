package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailsPIM_UI;
import pageUIs.orangeHRM.pim.employee.DependentsPIM_UI;

public class DependentsP0 extends EmployeeTabs {
    private WebDriver driver;

    public DependentsP0(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickAddButtonAtAssignedDependentsContainer() {
        waitForElementClickable(driver, DependentsPIM_UI.ADD_BUTTON_AT_ASSIGNED_DEPENDENT_CONTAINER);
        clickToElement(driver, DependentsPIM_UI.ADD_BUTTON_AT_ASSIGNED_DEPENDENT_CONTAINER);
    }

    public void enterToNameTextBox(String nameDependent) {
        waitForElementVisible(driver, DependentsPIM_UI.NAME_TEXTBOX_AT_DEPENDENT_CONTAINER);
        sendkeyToElement(driver, DependentsPIM_UI.NAME_TEXTBOX_AT_DEPENDENT_CONTAINER, nameDependent );
    }

    public void selectRelationShipDropdownWithChildItem(String relationshipDependent) {
    }

    public void selectRelationShipDropdownWithOtherItem(String relationshipDependent) {
        waitForElementVisible(driver, DependentsPIM_UI.RELATIONSHIP_DROPDOWN_PARENT);
        selectItemCustomDropdown(driver, DependentsPIM_UI.RELATIONSHIP_DROPDOWN_PARENT, DependentsPIM_UI.RELATIONSHIP_DROPDOWN_CHILDREN, relationshipDependent);
    }

    public void enterToPleaseSpecifyTextBox(String specifyRelationship) {
        waitForElementVisible(driver, DependentsPIM_UI.PLEASE_SPECIFY_TEXTBOX_AT_DEPENDENT_CONTAINER);
        sendkeyToElement(driver, DependentsPIM_UI.PLEASE_SPECIFY_TEXTBOX_AT_DEPENDENT_CONTAINER, specifyRelationship );
    }

    public void enterDateOfBirthTextbox(String dateOfBirthDependent) {
        waitForElementVisible(driver, DependentsPIM_UI.DATE_OF_BIRTH_TEXTBOX_AT_DEPENDENT_CONTAINER);
        sendkeyToElement(driver, DependentsPIM_UI.DATE_OF_BIRTH_TEXTBOX_AT_DEPENDENT_CONTAINER, dateOfBirthDependent);
    }

    public void clickToSaveButtonAtDependentsContainer() {
        waitForElementClickable(driver, DependentsPIM_UI.SAVE_BUTTON_AT_DEPENDENT_CONTAINER);
        clickToElement(driver, DependentsPIM_UI.SAVE_BUTTON_AT_DEPENDENT_CONTAINER);

    }
}
