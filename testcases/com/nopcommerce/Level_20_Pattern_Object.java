package com.nopcommerce;

import commons.BaseTest;

import jiraConfigs.JiraCreateIssue;
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


public class Level_20_Pattern_Object extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

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



    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserCustomerInforPageObject customerPage;
    OrderPageObject orderPage;
    RewardPointPageObject rewardPointPage;
    AddressPageObject addressPage;
    String firstName, lastName, emailAddress, companyName, password;

}
