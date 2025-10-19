package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.*;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;

import java.sql.SQLException;

public class Level_30_Database_Testing extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getHomePage(driver);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName = "Twiyo";
        password = "gK3@*09`%NO";
    }
        @Test
        public void User_01_Register() throws SQLException {
        // PRE-CONDITION
        userRegisterPage = userHomePage.clickToRegisterLink();
        userRegisterPage = PageGenerator.getRegisterPage(driver);

        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConformPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
        userCustomerPage = userHomePage.clickToMyAccountLinkAtUserSite(driver);

        // Logout
        userHomePage = userCustomerPage.clickToLogoutLinkAtUserSite(driver);

        //  Login vào Admin site
        userLoginPage = userHomePage.clickToLoginLink();
        userLoginPage.enterToEmailTextbox(GlobalConstants.NOP_ADMIN_USERNAME);
        userLoginPage.enterToPasswordTextbox(GlobalConstants.NOP_ADMIN_PASSWORD);
        userLoginPage.clickToLoginButton();

        adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

        adminLoginPage = userHomePage.openAdminSite(driver, GlobalConstants.LOCAL_DEV_URL + "Admin");
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        adminDashboardPage.openPageUrl(driver, GlobalConstants.LOCAL_DEV_URL + "Admin/Customer/List");
        adminCustomerPage = PageGenerator.getAdminCustomerPage(driver);
        Assert.assertTrue(adminCustomerPage.isPageLoadedSuccess(driver));

        int customerNumberUI = adminCustomerPage.getAllCustomerNumberUI();

        adminCustomerPage.refreshCurrentPage(driver);

        adminCustomerPage.enterToEmailTextboxSearch(emailAddress);
        adminCustomerPage.clickToSearchButton();

        Assert.assertTrue(adminCustomerPage.isCustomerPageDisplayed(emailAddress));

        int customerNumberDB = adminCustomerPage.getAllCustomerNumberInDatabase();

        Assert.assertTrue(adminCustomerPage.isEmailAddressInDatabase(emailAddress));

        Assert.assertEquals(customerNumberUI, customerNumberDB);

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
    AdminCustomerPageObject adminCustomerPage;
    String firstName, lastName, emailAddress, companyName, password;
    String userUrl, adminUrl;

}
