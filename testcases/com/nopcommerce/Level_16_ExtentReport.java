package com.nopcommerce;


import com.aventstack.extentreports.Status;
import commons.BaseTest;

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
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Level_16_ExtentReport extends BaseTest {
    String browserName;

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        this.browserName = browserName.toUpperCase();

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }

    @Test
    public void TC_01_Register(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "TC_01_Register");

        ExtentManager.getTest().log(Status.INFO, "NewCustomer - Step 01: Open Register Page");
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 02: Enter to Firstname textbox with value" + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 03: Enter to Lastname textbox with value" + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 04: Enter to Email textbox with value" + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 05: Enter to Password textbox with value" + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 06: Enter to Confirm Password textbox with value" + password);
        registerPage.enterToConformPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 07: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 08: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 09: Click to Logout link");
        registerPage.clickToLogoutLinkAtUserSite(driver);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @Test
    public void TC_02_Login(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "TC_02_Login");

        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }

    @Test
    public void TC_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "TC_03_MyAccount");

        homePage.clickToMyAccountLinkAtUserSite(driver);
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class,driver);

        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxValue(),emailAddress);
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
