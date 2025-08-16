package com.orangehrm.pim.employee;


import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.employee.*;

import java.util.ArrayList;
import java.util.List;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddNewEmployeePO addNewEmployeePage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private ContactDetailsPO contactDetailPage;
    private EmergencyContactsPO emergencyDetailPage;
    private DependentsP0 assignedDependentsPage;
    String employeeID, userName, password, firstName, lastName, avatar, editFirstName, editLastName,
            driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    String street1, street2, city, state, zipCode, country, telephoneNumberOfHome, telephoneNumberOfWork, telephoneNumberOfMobile, workEmail, otherEmail;
    String nameEmergency, relationship, telephoneNumberOfHomeEmergency, telephoneNumberOfMobileEmergency, telephoneNumberOfWorkEmergency;
    String nameDependent, relationshipDependent, specifyRelationship, dateOfBirthDependent;


    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        userName = "HieuLND";
        password = "99*10bsFiOXrmERLTO";
        firstName = "Marley";
        lastName = "Grollmann";
        editFirstName = "Mimi";
        editLastName = "Dodo";
        avatar = "avatar_employee.jpg";
        driverLicenseNumber = "55-662-9883";
        driverLicenseExpiryDate = "2027-10-10";
        nationality = "Vietnamese";
        maritalStatus = "Single";
        dateOfBirth = "1994-10-18";
        gender = "Female";

        street1 = "Ngu Binh";
        street2 = "Ngu Hanh Son";
        city = "Da Nang";
        state = "Da Nang";
        zipCode = "555000";
        country = "Viet Nam";
        telephoneNumberOfHome = "1513656944";
        telephoneNumberOfWork = "2597289023";
        telephoneNumberOfMobile = "5438496655";
        workEmail = "kride3@geocities.com";
        otherEmail = "pjiru1@ifeng.com";

        nameEmergency = "Belia Uccello";
        relationship = "Sister";
        telephoneNumberOfHomeEmergency = "6066994328";
        telephoneNumberOfMobileEmergency = "9011086680";
        telephoneNumberOfWorkEmergency = "8551466617";

        nameDependent = "Janette Keel";
        relationshipDependent = "Other";
        specifyRelationship = "Friend";
        dateOfBirthDependent = "1994-10-16";



        driver = getBrowserDriver(url,browserName);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUserNameTextBox(userName);
        loginPage.enterToPasswordTextBox(password);

        dashboardPage = loginPage.clickToLoginButton();
        dashboardPage.sleepInSecond(3);

    }

    @Test
    public void Employee_01_Add_New_Employee() {
        // Wait cho all loading icon biên mất trên 1 page
        employeeListPage = dashboardPage.clickToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeLink();

        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID(driver);
        // System.out.println("Employee ID" + employeeID);

        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        // Lấy ra height/ width của element (avatar) => A
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadMultipleFiles(driver, avatar);

        personalDetailsPage.clickToSaveButtonAtProfileContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));
    }

    @Test
    public void Employee_03_Personal_Details() {
        personalDetailsPage.openPersonalDetailsPage();

        personalDetailsPage.enterToFirstNameTextBox(editFirstName);
        personalDetailsPage.enterToLastNameTextBox(editLastName);

        personalDetailsPage.enterToDriverLicenseTextbox(driverLicenseNumber);
        personalDetailsPage.enterToLicenseDateTextbox(driverLicenseExpiryDate);
        personalDetailsPage.selectNationalityDropdown(nationality);
        personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);

        personalDetailsPage.enterDateOfBirthTextBox(dateOfBirth);

        personalDetailsPage.selectGenderFemaleRadioButton(gender);

        personalDetailsPage.clickToSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(),editFirstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(),editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(),driverLicenseNumber);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateTextboxValue(),driverLicenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(), nationality);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(), maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderFemaleRadioSelected(gender));

    }

    @Test
    public void Employee_04_Contact_Details() {
        contactDetailPage = personalDetailsPage.openContactDetailPage();
        System.out.println(contactDetailPage.toString());

        contactDetailPage.enterToStreet1Textbox(street1);
        contactDetailPage.enterToStreet2Textbox(street2);
        contactDetailPage.enterToCityTextbox(city);
        contactDetailPage.enterToStateTextbox(state);
        contactDetailPage.enterToZipCodeTextbox(zipCode);
        contactDetailPage.selectCountryDropdown(country);

        contactDetailPage.enterToTelephoneNumberOfHomeTextbox(telephoneNumberOfHome);
        contactDetailPage.enterToTelephoneNumberOfMobileTextbox(telephoneNumberOfMobile);
        contactDetailPage.enterToTelephoneNumberOfWorkTextbox(telephoneNumberOfWork);

        contactDetailPage.enterToWorkEmailTextbox(workEmail);
        contactDetailPage.enterToOtherEmailTextbox(otherEmail);

        contactDetailPage.clickToSaveButtonAtContactDetailContainer();
        Assert.assertTrue(contactDetailPage.isSuccessMessageIsDisplayed(driver));
        contactDetailPage.waitAllLoadingIconInvisible(driver);

        // Verìy
        Assert.assertEquals(contactDetailPage.getStreet1TextboxValue(),street1);
        Assert.assertEquals(contactDetailPage.getStreet2TextboxValue(),street2);
        Assert.assertEquals(contactDetailPage.getCityTextboxValue(),city);
        Assert.assertEquals(contactDetailPage.getStateTextboxValue(),state);
        Assert.assertEquals(contactDetailPage.getZipCodeTextboxValue(),zipCode);
        Assert.assertEquals(contactDetailPage.getCountryDropdownValue(),country);
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfHomeTextboxValue(),telephoneNumberOfHome);
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfMobileTextboxValue(),telephoneNumberOfMobile);
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfWorkTextboxValue(),telephoneNumberOfWork);
        Assert.assertEquals(contactDetailPage.getWorkEmailTextboxValue(),workEmail);
        Assert.assertEquals(contactDetailPage.getOtherEmailTextboxValue(),otherEmail);
    }

    @Test
    public void Employee_05_Emergency_Details() {
        emergencyDetailPage = contactDetailPage.openEmergencyDetailPage();

        emergencyDetailPage.clickToAddButtonAtAssignedEmergencyContactsContainer();
        emergencyDetailPage.sleepInSecond(3);

        emergencyDetailPage.enterToNameTextboxAtSaveEmergencyContact(nameEmergency);
        emergencyDetailPage.enterToRelationshipTextboxAtSaveEmergencyContact(relationship);
        emergencyDetailPage.enterToHomeTelephoneTextboxAtSaveEmergencyContact(telephoneNumberOfHomeEmergency);
        emergencyDetailPage.enterToMobileTextboxAtSaveEmergencyContact(telephoneNumberOfMobileEmergency);
        emergencyDetailPage.enterToWorkTelephoneTextboxAtSaveEmergencyContact(telephoneNumberOfWorkEmergency);

        emergencyDetailPage.clickToSaveButtonAtAssignedEmergencyContactsContainer();
        Assert.assertTrue(emergencyDetailPage.isSuccessMessageIsDisplayed(driver));
        emergencyDetailPage.waitAllLoadingIconInvisible(driver);

//        List<String> actualName = new ArrayList<>();
//        List<String> expectedName = emergencyDetailPage.getAllValueAtColumnName();
//        emergencyDetailPage.showRowData(expectedName);

//        Assert.assertEquals(emergencyDetailPage.getNameTextboxValue(nameEmergency));
//        Assert.assertEquals(emergencyDetailPage.getRelationshipTextboxValue(relationship));
//        Assert.assertEquals(emergencyDetailPage.getHomeTelephoneTextboxValue(telephoneNumberOfHomeEmergency));
//        Assert.assertEquals(emergencyDetailPage.getMobileTextboxValue(telephoneNumberOfMobileEmergency));
//        Assert.assertEquals(emergencyDetailPage.getWorkTelephoneTextboxValue(telephoneNumberOfWorkEmergency));
    }

   @Test
    public void Employee_06_Assigned_Dependents() {
        assignedDependentsPage = emergencyDetailPage.openAssignedDependentsPage();

        assignedDependentsPage.clickAddButtonAtAssignedDependentsContainer();
        assignedDependentsPage.sleepInSecond(3);

        assignedDependentsPage.enterToNameTextBox(nameDependent);
        // assignedDependentsPage.selectRelationShipDropdownWithChildItem();

        assignedDependentsPage.selectRelationShipDropdownWithOtherItem(relationshipDependent);
        assignedDependentsPage.sleepInSecond(2);

        assignedDependentsPage.enterToPleaseSpecifyTextBox(specifyRelationship);
        assignedDependentsPage.enterDateOfBirthTextbox(dateOfBirthDependent);

        assignedDependentsPage.clickToSaveButtonAtDependentsContainer();

        Assert.assertTrue(assignedDependentsPage.isSuccessMessageIsDisplayed(driver));
        assignedDependentsPage.waitAllLoadingIconInvisible(driver);


    }

    @Test
    public void Employee_07_Edit_View_Job() {

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
