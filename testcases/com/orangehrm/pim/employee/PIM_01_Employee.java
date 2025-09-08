package com.orangehrm.pim.employee;


import commons.BaseTest;
import commons.GlobalConstants;
import dataOrangeHRM.EmployeeInfor;
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
    private EmployeeInfor employeeInfor;

    String employeeID, userName, password, firstName, lastName, avatar, editFirstName, editLastName,
            driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    String street1, street2, city, state, zipCode, country, telephoneNumberOfHome, telephoneNumberOfWork, telephoneNumberOfMobile, workEmail, otherEmail;
    String nameEmergency, relationship, telephoneNumberOfHomeEmergency, telephoneNumberOfMobileEmergency, telephoneNumberOfWorkEmergency;
    String nameDependent, relationshipDependent, specifyRelationship, dateOfBirthDependent;


    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName) {
        driver = getBrowserDriver(url,browserName);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox(GlobalConstants.ADMIN_USERNAME_ORANGEHRM);
        loginPage.enterToPasswordTextBox(GlobalConstants.ADMIN_PASSWORD_ORANGEHRM);
        dashboardPage = loginPage.clickToLoginButton();
        dashboardPage.sleepInSecond(3);

        employeeInfor = EmployeeInfor.getUserData();
        employeeInfor.setFirstName("Marley");
        employeeInfor.setLastName("Grollmann");

        avatar = "avatar_employee.jpg";

        employeeInfor.setEditFirstName("Mimi");
        employeeInfor.setEditLastName("Dodo");
        employeeInfor.setDriverLicenseNumber("55-662-9883");
        employeeInfor.setDriverLicenseExpiryDate("2027-10-10");
        employeeInfor.setNationality("Vietnamese");
        employeeInfor.setMaritalStatus("Single");
        employeeInfor.setDateOfBirth("1994-10-18");
        employeeInfor.setGender("Female");

        employeeInfor.setStreet1("Ngu Binh");
        employeeInfor.setStreet2("Ngu Hanh Son");
        employeeInfor.setCity("Da Nang");
        employeeInfor.setCountry("Viet Nam");
        employeeInfor.setZipCode("555000");
        employeeInfor.setState("Da Nang");
        employeeInfor.setTelephoneNumberOfHome("1513656944");
        employeeInfor.setTelephoneNumberOfWork("2597289023");
        employeeInfor.setTelephoneNumberOfMobile("5438496655");
        employeeInfor.setWorkEmail("kride" + generateFakeNumber() + "@gmail.com");
        employeeInfor.setOtherEmail("pjiru" + generateFakeNumber() + "@gmail.com");

        employeeInfor.setNameEmergency("Belia Uccello");
        employeeInfor.setRelationship("Sister");
        employeeInfor.setTelephoneNumberOfHomeEmergency("6066994328");
        employeeInfor.setTelephoneNumberOfMobileEmergency("9011086680");
        employeeInfor.setTelephoneNumberOfWorkEmergency("8551466617");

        nameDependent = "Janette Keel";
        relationshipDependent = "Other";
        specifyRelationship = "Friend";
        dateOfBirthDependent = "1994-10-16";


    }

    @Test
    public void Employee_01_Add_New_Employee() {
        // Wait cho all loading icon biên mất trên 1 page
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeLink();

        addNewEmployeePage.enterToAddNewEmployeeForm(employeeInfor);

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

        personalDetailsPage.enterToDetailsPageForm(employeeInfor);

        personalDetailsPage.clickToSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(),employeeInfor.getEditFirstName());
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(),employeeInfor.getEditLastName());
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(),employeeInfor.getDriverLicenseNumber());
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateTextboxValue(),employeeInfor.getDriverLicenseExpiryDate());
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(), employeeInfor.getNationality());
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(),employeeInfor.getMaritalStatus());
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), employeeInfor.getDateOfBirth());
        Assert.assertTrue(personalDetailsPage.isGenderFemaleRadioSelected(employeeInfor.getGender()));

    }

    @Test
    public void Employee_04_Contact_Details() {
        contactDetailPage = personalDetailsPage.openContactDetailPage();

        contactDetailPage.enterToContactDetailsForm(employeeInfor);

        contactDetailPage.clickToSaveButtonAtContactDetailContainer();
        Assert.assertTrue(contactDetailPage.isSuccessMessageIsDisplayed(driver));
        contactDetailPage.waitAllLoadingIconInvisible(driver);

        // Verìy
        Assert.assertEquals(contactDetailPage.getStreet1TextboxValue(),employeeInfor.getStreet1());
        Assert.assertEquals(contactDetailPage.getStreet2TextboxValue(),employeeInfor.getStreet2());
        Assert.assertEquals(contactDetailPage.getCityTextboxValue(),employeeInfor.getCity());
        Assert.assertEquals(contactDetailPage.getStateTextboxValue(),employeeInfor.getState());
        Assert.assertEquals(contactDetailPage.getZipCodeTextboxValue(),employeeInfor.getZipCode());
        Assert.assertEquals(contactDetailPage.getCountryDropdownValue(),employeeInfor.getCountry());
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfHomeTextboxValue(),employeeInfor.getTelephoneNumberOfHome());
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfMobileTextboxValue(),employeeInfor.getTelephoneNumberOfMobile());
        Assert.assertEquals(contactDetailPage.getTelephoneNumberOfWorkTextboxValue(),employeeInfor.getTelephoneNumberOfWork());
        Assert.assertEquals(contactDetailPage.getWorkEmailTextboxValue(),employeeInfor.getWorkEmail());
        Assert.assertEquals(contactDetailPage.getOtherEmailTextboxValue(),employeeInfor.getOtherEmail());

        contactDetailPage.sleepInSecond(3);
    }

    @Test
    public void Employee_05_Emergency_Details() {
        emergencyDetailPage = contactDetailPage.openEmergencyDetailPage();

        emergencyDetailPage.clickToAddButtonAtAssignedEmergencyContactsContainer();
        emergencyDetailPage.sleepInSecond(3);

        emergencyDetailPage.enterToEmergencyDetailsForm(employeeInfor);

        emergencyDetailPage.clickToSaveButtonAtAssignedEmergencyContactsContainer();
        Assert.assertTrue(emergencyDetailPage.isSuccessMessageIsDisplayed(driver));
        emergencyDetailPage.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(emergencyDetailPage.getNameTextboxValue(),employeeInfor.getNameEmergency());
        Assert.assertEquals(emergencyDetailPage.getRelationshipTextboxValue(), employeeInfor.getRelationship());
        Assert.assertEquals(emergencyDetailPage.getHomeTelephoneTextboxValue(), employeeInfor.getTelephoneNumberOfHomeEmergency());
        Assert.assertEquals(emergencyDetailPage.getMobileTextboxValue(), employeeInfor.getTelephoneNumberOfMobileEmergency());
        Assert.assertEquals(emergencyDetailPage.getWorkTelephoneTextboxValue(), employeeInfor.getTelephoneNumberOfWorkEmergency());
    }

   @Test
    public void Employee_06_Assigned_Dependents() {
        assignedDependentsPage = emergencyDetailPage.openAssignedDependentsPage();

//        assignedDependentsPage.clickAddButtonAtAssignedDependentsContainer();
//        assignedDependentsPage.sleepInSecond(3);
//
//        assignedDependentsPage.enterToNameTextBox(nameDependent);
//        // assignedDependentsPage.selectRelationShipDropdownWithChildItem();
//
//        assignedDependentsPage.selectRelationShipDropdownWithOtherItem(relationshipDependent);
//        assignedDependentsPage.sleepInSecond(2);
//
//        assignedDependentsPage.enterToPleaseSpecifyTextBox(specifyRelationship);
//        assignedDependentsPage.enterDateOfBirthTextbox(dateOfBirthDependent);
//
//        assignedDependentsPage.clickToSaveButtonAtDependentsContainer();
//
//        Assert.assertTrue(assignedDependentsPage.isSuccessMessageIsDisplayed(driver));
//        assignedDependentsPage.waitAllLoadingIconInvisible(driver);


    }

    @Test
    public void Employee_07_Edit_View_Job() {

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
