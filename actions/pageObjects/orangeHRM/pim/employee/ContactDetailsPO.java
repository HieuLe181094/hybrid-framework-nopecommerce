package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import commons.BaseTest;
import dataOrangeHRM.EmployeeInfor;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailsPIM_UI;

public class ContactDetailsPO extends EmployeeTabs {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToStreet1Textbox(String street1) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STREET1_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.STREET1_TEXTBOX, street1);
    }

    public void enterToStreet2Textbox(String street2) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STREET2_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.STREET2_TEXTBOX, street2);
    }

    public void enterToCityTextbox(String city) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.CITY_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.CITY_TEXTBOX, city);
    }

    public void enterToStateTextbox(String state) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STATE_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.STATE_TEXTBOX, state);
    }

    public void enterToZipCodeTextbox(String zipCode) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.ZIPCODE_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.ZIPCODE_TEXTBOX, zipCode);
    }

    public void selectCountryDropdown(String country) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.COUNTRY_DROPDOWN_PARENT);
        selectItemCustomDropdown(driver, ContactDetailsPIM_UI.COUNTRY_DROPDOWN_PARENT, ContactDetailsPIM_UI.COUNTRY_DROPDOWN_CHILD, country);
    }

    public void enterToTelephoneNumberOfHomeTextbox(String telephoneNumberOfHome ) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_HOME_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_HOME_TEXTBOX, telephoneNumberOfHome);
    }

    public void enterToTelephoneNumberOfMobileTextbox(String telephoneNumberOfMobile) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_MOBILE_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_MOBILE_TEXTBOX, telephoneNumberOfMobile);
    }

    public void enterToTelephoneNumberOfWorkTextbox(String telephoneNumberOfWork) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_WORK_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_WORK_TEXTBOX, telephoneNumberOfWork);
    }

    public void enterToWorkEmailTextbox(String workEmail) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.WORK_EMAIL_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.WORK_EMAIL_TEXTBOX, workEmail);
    }

    public void enterToOtherEmailTextbox(String otherEmail) {
        waitForElementVisible(driver, ContactDetailsPIM_UI.OTHER_EMAIL_TEXTBOX);
        sendkeyToElement(driver, ContactDetailsPIM_UI.OTHER_EMAIL_TEXTBOX, otherEmail);
    }

    public void clickToSaveButtonAtContactDetailContainer() {
        waitForElementClickable(driver, ContactDetailsPIM_UI.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
        clickToElement(driver, ContactDetailsPIM_UI.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
    }

    public String getStreet1TextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STREET1_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.STREET1_TEXTBOX, "value");
    }

    public  String getStreet2TextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STREET2_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.STREET2_TEXTBOX, "value");
    }

    public  String getCityTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.CITY_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.CITY_TEXTBOX, "value");
    }

    public  String getStateTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.STATE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.STATE_TEXTBOX, "value");
    }

    public  String getZipCodeTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.ZIPCODE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.ZIPCODE_TEXTBOX, "value");
    }

    public  String getCountryDropdownValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.COUNTRY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, ContactDetailsPIM_UI.COUNTRY_DROPDOWN_ITEM_SELECTED);
    }

    public  String getTelephoneNumberOfHomeTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_HOME_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_HOME_TEXTBOX, "value");
    }

    public String getTelephoneNumberOfMobileTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_MOBILE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_MOBILE_TEXTBOX, "value");
    }

    public String getTelephoneNumberOfWorkTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_WORK_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.TELEPHONE_NUMBER_WORK_TEXTBOX, "value");
    }

    public  String getWorkEmailTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.WORK_EMAIL_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.WORK_EMAIL_TEXTBOX, "value");
    }

    public  String getOtherEmailTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPIM_UI.OTHER_EMAIL_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPIM_UI.OTHER_EMAIL_TEXTBOX, "value");
    }


    public void enterToContactDetailsForm(EmployeeInfor employeeInfor) {
        enterToStreet1Textbox(employeeInfor.getStreet1());
        enterToStreet2Textbox(employeeInfor.getStreet2());
        enterToCityTextbox(employeeInfor.getCity());
        enterToStateTextbox(employeeInfor.getState());
        enterToZipCodeTextbox(employeeInfor.getZipCode());
        selectCountryDropdown(employeeInfor.getCountry());
        enterToTelephoneNumberOfHomeTextbox(employeeInfor.getTelephoneNumberOfHome());
        enterToTelephoneNumberOfMobileTextbox(employeeInfor.getTelephoneNumberOfMobile());
        enterToTelephoneNumberOfWorkTextbox(employeeInfor.getTelephoneNumberOfWork());
        enterToWorkEmailTextbox(employeeInfor.getWorkEmail());
        enterToOtherEmailTextbox(employeeInfor.getOtherEmail());
    }
}
