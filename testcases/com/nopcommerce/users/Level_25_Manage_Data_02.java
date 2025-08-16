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
import utilities.FakerNet;


public class Level_25_Manage_Data_02 extends BaseTest {
    private String firstName, lastName, emailAddress, companyName, password;

    @Parameters({"urlUser","browser","firstName","lastName","emailAddress",
            "companyName","password"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName, String firstName, String lastName, String emailAddress, String companyName, String password) {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress + generateFakeNumber() + "@mail.vn";
        this.companyName= companyName;
        this.password = password;

    }


    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);
        registerPage.enterToTextboxByID(driver, "LastName", lastName);
        registerPage.enterToTextboxByID(driver, "Email", emailAddress);
        registerPage.enterToTextboxByID(driver, "Company", companyName);

        registerPage.clickToCheckBoxByID(driver, "Newsletter");

        registerPage.enterToTextboxByID(driver, "Password", password);
        registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);

        registerPage.clickButtonByText(driver,"Register");

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");

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



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserCustomerInforPageObject customerPage;
    OrderPageObject orderPage;
    RewardPointPageObject rewardPointPage;
    AddressPageObject addressPage;

    private FakerNet faker;


}
