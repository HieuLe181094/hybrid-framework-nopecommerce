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

public class Level_09_Switch_URL extends BaseTest {
    @Parameters({"urlUser", "urlAdmin","browser"})
    @BeforeClass
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(this.userUrl, browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        userHomePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

        // PRE-CONDITION
        userRegisterPage = userHomePage.clickToRegisterLink();

        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConformPasswordTextbox(password);

        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");

        userCustomerPage = userHomePage.clickToMyAccountLink(driver);
    }

    @Test
    public void TC_01_Order() {
        // Desktop Page

        // Order 1 product  - Order ID (status is Pending)
        // ...

        // Get Order ID

        userHomePage = userCustomerPage.clickToLogoutLink(driver);

        adminLoginPage = userHomePage.openAdminSite(driver, adminUrl);

//        adminLoginPage.enterToEmailTextbox("admin@yourstore.com");
//        adminLoginPage.enterToPasswordTextbox("admin");
//        adminDashboardPage = adminLoginPage.clickLoginButton();

        // Open Sale Page

        // Open Order Page

        // Change Order status Complete/ Paid

        // Switch to User site - Check Order status
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



    WebDriver driver;
    UserHomePageObject userHomePage;
    UserLoginPageObject userLoginPage;
    UserRegisterPageObject userRegisterPage;
    UserCustomerInforPageObject userCustomerPage;
    AdminLoginPageObject adminLoginPage;
    AdminDashboardPageObject adminDashboardPage;
    String firstName, lastName, emailAddress, companyName, password;
    String userUrl, adminUrl;

}
