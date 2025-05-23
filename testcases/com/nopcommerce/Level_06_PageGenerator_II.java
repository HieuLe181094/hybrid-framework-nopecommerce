package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;
import pageObjects.nopCommerce.UserHomePageObject;
import pageObjects.nopCommerce.UserLoginPageObject;
import pageObjects.nopCommerce.UserRegisterPageObject;

public class Level_06_PageGenerator_II extends BaseTest {
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        // Khởi tạo lên cái driver tương ứng dựa vào tên Browser
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        // Khởi tạo ra 1 instance của class HomePageObject
        homePage = new UserHomePageObject(driver);

    }

    @Test
    public void TC_01_Register() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConformPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        homePage = registerPage.clickToLogoutLinkAtUserSite(driver);

    }

    @Test
    public void TC_02_Login() {
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);

        homePage = loginPage.clickToLoginButton();

    }

    @Test
    public void TC_03_MyAccount() {
        customerPage = homePage.clickToMyAccountLinkAtUserSite(driver);

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
