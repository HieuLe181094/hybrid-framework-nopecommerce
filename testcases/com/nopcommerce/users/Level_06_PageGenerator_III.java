package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.*;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;

public class Level_06_PageGenerator_III extends BaseTest {
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getRegisterPage(driver);

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConformPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLinkAtUserSite(driver);

        // Về lại trang Home: từ page A qua page B
        // RegisterPage qua HomePage
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();

        // Từ page A qua page B
        // Từ Home qua Login
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

//        loginPage.loginToSystem(emailAddress,password);
//        loginPage.clickToLoginButton();

        // Từ page A qua lại page B
        // Tù Login về Home
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);

        // Từ page A qua page B
        // Từ Login về CustomerInfo
        customerPage = PageGenerator.getCustomerInfoPage(driver);

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
