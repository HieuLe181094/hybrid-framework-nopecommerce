package com.nopcommerce.users;

import commons.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.UserHomePageObject;
import pageObjects.nopCommerce.UserLoginPageObject;
import pageObjects.nopCommerce.UserRegisterPageObject;
import pageObjects.nopCommerce.sideBar.AddressPageObject;
import pageObjects.nopCommerce.sideBar.OrderPageObject;
import pageObjects.nopCommerce.sideBar.RewardPointPageObject;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;


public class Level_20_Pattern_Object_2 extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        addresses_firstName = "Automation";
        addresses_lastName = "FC";
        addresses_Email = "automationfc.vn@gmail.com";
        addresses_Company = "Automation FC";
        addresses_Country  = "Vietnam";
        addresses_State = "Đà Nẵng";
        addresses_City = "Da Nang";
        addresses1 = "123/04 Le Lai";
        addresses2 = "234/05 Hai Phong";
        zipValue = "550000";
        addresses_phoneNumber = "0123456789";
        addresses_faxNumber = "0987654321";

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }


    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);
        registerPage.enterToTextboxByID(driver, "LastName",lastName);
        registerPage.enterToTextboxByID(driver, "Email",emailAddress);
        registerPage.enterToTextboxByID(driver, "Company",companyName);

        registerPage.clickToCheckBoxByID(driver, "Newsletter");

        registerPage.enterToTextboxByID(driver, "Password", password);
        registerPage.enterToTextboxByID(driver, "ConfirmPassword",password);

        registerPage.clickButtonByText(driver,"Register");

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLinkAtUserSite(driver);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }


    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", password);

        loginPage.clickButtonByText(driver, "Log in");

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }


    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class,driver);

        Assert.assertTrue(customerPage.isGenderMaleSelected(driver, "gender-female"));

        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "FirstName"),firstName);
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "LastName"),lastName);
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "Email"),emailAddress);
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "Company"),companyName);

        Assert.assertTrue(customerPage.isNewletterCheckboxSelected(driver, "Newsletter"));
    }

    @Test
    public void TC_04_MyAcount_Addresses(){
        addressPage = (AddressPageObject) customerPage.openSideBarByPageName("Addresses");
        addressPage.sleepInSecond(3);
        addressPage.clickButtonByText(driver,"Add new");
        addressPage.sleepInSecond(3);

        addressPage.enterToTextboxByID(driver,"Address_FirstName", addresses_firstName);
        addressPage.enterToTextboxByID(driver,"Address_LastName", addresses_lastName);
        addressPage.enterToTextboxByID(driver,"Address_Email", addresses_Email);
        addressPage.enterToTextboxByID(driver,"Address_Company", addresses_Company);
        addressPage.enterToTextboxByID(driver,"Address_City", addresses_City );

        addressPage.selectToDropdownByID(driver,"Address_CountryId", addresses_Country);
        addressPage.selectToDropdownByID(driver, "Address_StateProvinceId", addresses_State);

        addressPage.enterToTextboxByID(driver,"Address_Address1", addresses1 );
        addressPage.enterToTextboxByID(driver,"Address_Address2", addresses2 );
        addressPage.enterToTextboxByID(driver,"Address_ZipPostalCode", zipValue );
        addressPage.enterToTextboxByID(driver,"Address_PhoneNumber", addresses_phoneNumber );
        addressPage.enterToTextboxByID(driver,"Address_FaxNumber", addresses_faxNumber );
        addressPage.sleepInSecond(4);

        addressPage.clickButtonByText(driver,"Save");
        addressPage.sleepInSecond(2);

        Assert.assertEquals(addressPage.getNewAddressesSuccessMessage(),"The new address has been added successfully.");
        addressPage.sleepInSecond(3);

        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"name"),addresses_firstName + " " + addresses_lastName);
        // Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"email"),addresses_Email);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"phone"),addresses_phoneNumber);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"fax"),addresses_faxNumber);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"stateprovince"),addresses_State);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"city"),addresses_City);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"address1"),addresses1);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"address2"),addresses2);
        Assert.assertEquals(addressPage.getAddressesInfoDisplayedByClass(driver,"zippostalcode"),zipValue);

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserCustomerInforPageObject customerPage;
    OrderPageObject orderPage;
    RewardPointPageObject rewardPointPage;
    AddressPageObject addressPage;
    String firstName, lastName, emailAddress, companyName, password,
            addresses_firstName, addresses_lastName, addresses_Email, addresses_Company, addresses_City,
            addresses_Country, addresses_State, addresses1, addresses2, zipValue,
            addresses_phoneNumber, addresses_faxNumber;
    ;

}
