package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import dataOrangeHRM.EmployeeInfor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.orangeHRM.pim.employee.PersonalDetailsPIM_UI;

public class PersonalDetailsPO extends EmployeeTabs {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPIM_UI.EMPLOYEE_IMAGE);
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPIM_UI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsPIM_UI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPIM_UI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailsPIM_UI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }
    
    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        sleepInSecond(5);
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }

    public void enterToFirstNameTextBox(String editFirstName) {
        // getWebElement(driver, locator).clear();
        waitForElementVisible(driver, PersonalDetailsPIM_UI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPIM_UI.FIRSTNAME_TEXTBOX, editFirstName);
    }

    public void enterToLastNameTextBox(String editLastName) {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPIM_UI.LASTNAME_TEXTBOX, editLastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.EMPLOYEE_ID_TEXTBOX, "value");
    }


    public void enterToDriverLicenseTextbox(String driverLicenseNumber) {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.DRIVER_LICENSE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPIM_UI.DRIVER_LICENSE_TEXTBOX, driverLicenseNumber );
    }

    public void enterToLicenseDateTextbox(String driverLicenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPIM_UI.LICENSE_EXPIRY_DATE_TEXTBOX, driverLicenseExpiryDate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPIM_UI.NATIONAL_DROPDOWN_PARENT);
        selectItemCustomDropdown(driver, PersonalDetailsPIM_UI.NATIONAL_DROPDOWN_PARENT, PersonalDetailsPIM_UI.NATIONAL_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPIM_UI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemCustomDropdown(driver, PersonalDetailsPIM_UI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPIM_UI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterDateOfBirthTextBox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.DATE_OF_BIRTH_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPIM_UI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderFemaleRadioButton(String gender) {
        clickToElementByJS(driver, PersonalDetailsPIM_UI.GENDER_RADIO_BUTTON, gender);
        checkToCheckboxRadio(driver, PersonalDetailsPIM_UI.GENDER_RADIO_BUTTON, gender);
    }


    public void clickToSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, PersonalDetailsPIM_UI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
        clickToElement(driver, PersonalDetailsPIM_UI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.LASTNAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.NATIONAL_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPIM_UI.NATIONAL_DROPDOWN_ITEM_SELECTED);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPIM_UI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPIM_UI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPIM_UI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderFemaleRadioSelected(String gender) {
        waitToElementSelected(driver, PersonalDetailsPIM_UI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPIM_UI.GENDER_RADIO_BUTTON, gender);
    }

    public void enterToDetailsPageForm(EmployeeInfor employeeInfor) {
        enterToFirstNameTextBox(employeeInfor.getEditFirstName());
        enterToLastNameTextBox(employeeInfor.getEditLastName());
        enterToDriverLicenseTextbox(employeeInfor.getDriverLicenseNumber());
        enterToLicenseDateTextbox(employeeInfor.getDriverLicenseExpiryDate());
        selectNationalityDropdown(employeeInfor.getNationality());
        selectMaritalStatusDropdown(employeeInfor.getMaritalStatus());
        enterDateOfBirthTextBox(employeeInfor.getDateOfBirth());
        selectGenderFemaleRadioButton(employeeInfor.getGender());
    }
}
