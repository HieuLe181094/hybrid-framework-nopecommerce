package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

public class Level_04_FactoryPattern extends BaseTest {
    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        homePage = (HomePageObject) PageManagement.getPage(driver,"HomePage");

    }

    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = (RegisterPageObject) PageManagement.getPage(driver,"RegisterPage");

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConformPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLink();

        // Về lại trang Home: từ page A qua page B
        // RegisterPage qua HomePage
        homePage = (HomePageObject) PageManagement.getPage(driver,"HomePage");
    }

    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();

        // Từ page A qua page B
        // Từ Home qua Login
        loginPage = (LoginPageObject) PageManagement.getPage(driver,"LoginPage");

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

//        loginPage.loginToSystem(emailAddress,password);
//        loginPage.clickToLoginButton();

        // Từ page A qua lại page B
        // Tù Login về Home
        homePage = (HomePageObject) PageManagement.getPage(driver,"HomePage");
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLink();

        // Từ page A qua page B
        // Từ Login về CustomerInfo
        customerPage = (CustomerInforPageObject) PageManagement.getPage(driver,"CustomerInfoPage");

        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxValue(),emailAddress);
    }



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    CustomerInforPageObject customerPage;
    String firstName, lastName, emailAddress, companyName, password;

}
