package pageObjects.orangeHRM.pim.employee;

import dataOrangeHRM.EmployeeInfor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;
import pageUIs.orangeHRM.pim.employee.EmergencyContactsPIM_UI;

import java.util.ArrayList;
import java.util.List;

public class EmergencyContactsPO extends EmployeeTabs {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddButtonAtAssignedEmergencyContactsContainer() {
        waitForElementClickable(driver, EmergencyContactsPIM_UI.ADD_BUTTON_AT_ASSIGNED_EMERGENCY_CONTACT_CONTAINER);
        clickToElement(driver, EmergencyContactsPIM_UI.ADD_BUTTON_AT_ASSIGNED_EMERGENCY_CONTACT_CONTAINER);
    }

    public void enterToNameTextboxAtSaveEmergencyContact(String nameEmergency) {
        waitForElementVisible(driver, EmergencyContactsPIM_UI.NAME_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER);
        sendkeyToElement(driver, EmergencyContactsPIM_UI.NAME_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER, nameEmergency);
    }

    public void enterToRelationshipTextboxAtSaveEmergencyContact(String relationship) {
        waitForElementVisible(driver, EmergencyContactsPIM_UI.RELATIONSHIP_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER);
        sendkeyToElement(driver, EmergencyContactsPIM_UI.RELATIONSHIP_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER, relationship);
    }

    public void enterToHomeTelephoneTextboxAtSaveEmergencyContact(String telephoneNumberOfHomeEmergency) {
        waitForElementVisible(driver, EmergencyContactsPIM_UI.HOME_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER);
        sendkeyToElement(driver, EmergencyContactsPIM_UI.HOME_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER, telephoneNumberOfHomeEmergency);
    }

    public void enterToMobileTextboxAtSaveEmergencyContact(String telephoneNumberOfMobileEmergency) {
        waitForElementVisible(driver, EmergencyContactsPIM_UI.MOBILE_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER);
        sendkeyToElement(driver, EmergencyContactsPIM_UI.MOBILE_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER, telephoneNumberOfMobileEmergency);
    }

    public void enterToWorkTelephoneTextboxAtSaveEmergencyContact(String telephoneNumberOfWorkEmergency) {
        waitForElementVisible(driver, EmergencyContactsPIM_UI.WORK_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER);
        sendkeyToElement(driver, EmergencyContactsPIM_UI.WORK_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER, telephoneNumberOfWorkEmergency);
    }

    public void clickToSaveButtonAtAssignedEmergencyContactsContainer() {
        waitForElementClickable(driver, EmergencyContactsPIM_UI.SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER);
        clickToElement(driver, EmergencyContactsPIM_UI.SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER);
    }


    public String getNameTextboxValue() {
        return null;
    }

    public String getRelationshipTextboxValue() {
        return null;
    }

    public String getHomeTelephoneTextboxValue() {
        return null;
    }

    public Object getMobileTextboxValue() {
        return null;
    }

    public String getWorkTelephoneTextboxValue() {
        return null;
    }

    public void enterToEmergencyDetailsForm(EmployeeInfor employeeInfor) {
        enterToNameTextboxAtSaveEmergencyContact(employeeInfor.getNameEmergency());
        enterToRelationshipTextboxAtSaveEmergencyContact(employeeInfor.getRelationship());
        enterToHomeTelephoneTextboxAtSaveEmergencyContact(employeeInfor.getTelephoneNumberOfHomeEmergency());
        enterToMobileTextboxAtSaveEmergencyContact(employeeInfor.getTelephoneNumberOfMobileEmergency());
        enterToWorkTelephoneTextboxAtSaveEmergencyContact(employeeInfor.getTelephoneNumberOfWorkEmergency());
    }


//    public List<String> getAllValueAtColumnName(String columnName) {
//        List<String> expectedAllRowValue = new ArrayList<>();
//        int columnIndex = getListElementSize(driver, EmergencyContactsPIM_UI.COLUMN_NUMBER_BY_COLUMN_NAME, columnName ) +1;
//    }
//
//    public void showRowData(List<String> rowData){
//        System.out.println("==================================================");
//        for (String data: rowData){
//            System.out.println(data);
//        }
//        System.out.println("==================================================");
//    }
}
