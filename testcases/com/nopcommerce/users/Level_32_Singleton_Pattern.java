package com.nopcommerce.users;

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
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;

public class Level_32_Singleton_Pattern extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        // Khởi tạo lần 1
        homePage = PageGenerator.getHomePage(driver);

        System.out.println("Thread ID = " + Thread.currentThread().getId() + " with browser = " + browserName);
        System.out.println("Thread ID = " + Thread.currentThread().getId() + " with driver = " + driver.toString());
        System.out.println("Thread ID = " + Thread.currentThread().getId() + " with home page instance = " + homePage.toString());

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";
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

        registerPage.clickToLogoutLinkAtUserSite(driver);

        // Khởi tạo lần 2
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
        System.out.println("Thread ID = " + Thread.currentThread().getId() + " with home page instance = " + homePage.toString());
    }

    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        // Khởi tạo lần 3
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
        System.out.println("Thread ID = " + Thread.currentThread().getId() + " with home page instance = " + homePage.toString());
    }

    @Test
    public void TC_03_MyAccount() {
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
    String firstName, lastName, emailAddress, companyName, password;

}