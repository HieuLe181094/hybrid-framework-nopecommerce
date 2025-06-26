package com.nopcommerce.users;


import com.nopcommerce.common.Login;
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


public class Level_21_Share_State_Close_Browser extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // Pre-condition: login by cookie
        homePage.setCookies(driver, Login.nopCommerceCookies);
        homePage.refreshCurrentPage(driver);

    }

    @Test
    public void User_01_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class,driver);

        Assert.assertTrue(customerPage.isGenderMaleSelected(driver, "gender-female"));
        Assert.assertTrue(customerPage.isNewletterCheckboxSelected(driver, "Newsletter"));
    }


    @Test
    public void  User_02_Order() {

    }

    @Test
    public void  User_03_Payment() {

    }



    @AfterClass(alwaysRun = true)
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
