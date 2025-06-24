package com.nopcommerce.common;

import commons.BaseTest;

import org.openqa.selenium.Cookie;
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

import java.util.Set;


public class Login extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeTest

    public void beforeTest(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // Data Test
        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        // New User
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

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");

        registerPage.clickToLogoutLinkAtUserSite(driver);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // Login
        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", password);
        loginPage.clickButtonByText(driver, "Log in");

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // Get Cookies
        nopCommerceCookies = homePage.getAllCookies(driver);

        driver.quit();

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
    public static Set<Cookie> nopCommerceCookies;

}
