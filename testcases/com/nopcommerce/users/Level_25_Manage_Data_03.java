package com.nopcommerce.users;

import commons.BaseTest;
import data.staticVar.Users;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.UserHomePageObject;
import pageObjects.nopCommerce.UserLoginPageObject;
import pageObjects.nopCommerce.UserRegisterPageObject;
import pageObjects.nopCommerce.sideBar.AddressPageObject;
import pageObjects.nopCommerce.sideBar.OrderPageObject;
import pageObjects.nopCommerce.sideBar.RewardPointPageObject;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;
import utilities.FakerNet;


public class Level_25_Manage_Data_03 extends BaseTest {
    private String firstName, lastName, emailAddress, companyName, password;

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        this.firstName = Users.RegisterLogin.FIRST_NAME;
        this.lastName = Users.RegisterLogin.LAST_NAME;
        this.emailAddress = Users.RegisterLogin.PREFIX_EMAIL_ADDRESS + generateFakeNumber() + Users.RegisterLogin.POSTFIX_EMAIL_ADDRESS;
        this.companyName= Users.RegisterLogin.COMPANY_NAME;
        this.password = Users.RegisterLogin.PASSWORD;

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
