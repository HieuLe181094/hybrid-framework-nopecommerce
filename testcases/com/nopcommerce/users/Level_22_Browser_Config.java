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

import java.io.IOException;


public class Level_22_Browser_Config extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }

    @Test
    public void User_01_MyAccount() {

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


}
