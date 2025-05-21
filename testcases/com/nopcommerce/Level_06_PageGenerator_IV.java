package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;

public class Level_06_PageGenerator_IV extends BaseTest {
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // Compile Code
        // PageGenerator.getPageInstance(BaseTest.class,driver);

    }

    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConformPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLink(driver);

        // Về lại trang Home: từ page A qua page B
        // RegisterPage qua HomePage
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();

        // Từ page A qua page B
        // Từ Home qua Login
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

//        loginPage.loginToSystem(emailAddress,password);
//        loginPage.clickToLoginButton();

        // Từ page A qua lại page B
        // Tù Login về Home
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLink(driver);

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
    String firstName, lastName, emailAddress, companyName, password;

}
