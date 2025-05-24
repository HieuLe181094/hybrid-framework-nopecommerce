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

public class Level_10_By_Locator extends BaseTest {
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

        userCustomerPage = userHomePage.clickToMyAccountLinkAtUserSite(driver);

        // Logout
        userHomePage = userCustomerPage.clickToLogoutLinkAtUserSite(driver);
    }

    @Test(description = "Login")
    public void TC_01_Required_Order() {
        // User site => Admin site
        adminLoginPage = userHomePage.openAdminSite(driver, adminUrl);

        adminLoginPage.enterToEmailTextbox("hiuhiu@gmail.com");
        adminLoginPage.enterToPasswordTextbox("hiuhiu@gmail.com");
        adminDashboardPage = adminLoginPage.clickLoginButton();
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

        // Logout
        adminDashboardPage.clickToLogoutAtAdminSite(driver);

        // Admin site => User site
        adminLoginPage.openUserSite(driver,userUrl);
    }

    @Test(description = "Dont Login")
    public void TC_02_Dont_Required_Login(){
        userLoginPage = userHomePage.clickToLoginLink();

        userLoginPage.enterToEmailTextbox(emailAddress);
        userLoginPage.enterToPasswordTextbox(password);
        userHomePage = userLoginPage.clickToLoginButton();

        userCustomerPage = userHomePage.clickToMyAccountLinkAtUserSite(driver);

        // User site => Admin site
        adminLoginPage = userCustomerPage.openAdminSite(driver,adminUrl);

        adminLoginPage.enterToEmailTextbox("hiuhiu@gmail.com");
        adminLoginPage.enterToPasswordTextbox("hiuhiu@gmail.com");
        adminLoginPage.clickLoginButton();
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

        adminProductPage = adminDashboardPage.openAdminProductPage(driver);

        //Admin site => User site
        userHomePage = adminProductPage.openUserSite(driver,userUrl);

        // Nếu Admin site đã login rồi thì sẽ vào Dashboard
        userHomePage.openAdminSite(driver,adminUrl);
        adminDashboardPage = PageGenerator.getPageInstance(AdminDashboardPageObject.class,driver);
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
    AdminProductPageObject adminProductPage;
    String firstName, lastName, emailAddress, companyName, password;
    String userUrl, adminUrl;

}
