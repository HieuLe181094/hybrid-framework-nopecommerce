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

@Listeners(jiraConfigs.JiraListener.class)
public class Level_18_JIRA extends BaseTest {

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

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_01_Register() {
        log.info("User_01_Register - STEP 01: Open Register Page");
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        log.info("User_01_Register - STEP 02: Enter to Firstname textbox with value" + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("User_01_Register - STEP 03: Enter to Lastname textbox with value" + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("User_01_Register - STEP 04: Enter to Email textbox with value" + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - STEP 05: Enter to Password textbox with value" + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 06: Enter to Confirm Password textbox with value" + password);
        registerPage.enterToConformPasswordTextbox(password);

        log.info("User_01_Register - STEP 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 08: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");

        log.info("User_01_Register - STEP 09: Click to Logout link");
        registerPage.clickToLogoutLinkAtUserSite(driver);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);


    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);

        // Từ page A qua page B
        // Từ Login về CustomerInfo
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
