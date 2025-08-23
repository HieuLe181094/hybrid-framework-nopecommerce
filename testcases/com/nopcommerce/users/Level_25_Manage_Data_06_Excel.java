package com.nopcommerce.users;

import commons.BaseTest;
import data.UserData;
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
import pageObjects.nopCommerce.sideBar.AddressPageObject;
import pageObjects.nopCommerce.sideBar.OrderPageObject;
import pageObjects.nopCommerce.sideBar.RewardPointPageObject;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;
import utilities.ExcelConfig;

import java.io.IOException;


public class Level_25_Manage_Data_06_Excel extends BaseTest {
    private String firstName, lastName, emailAddress, companyName, password;

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) throws IOException {
        driver = getBrowserDriver(urlValue,browserName);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);


        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("Employee");

        emailAddress = excelConfig.getCellData("EmailAddress", 1) + generateFakeNumber() + "@gmail.com";

    }


    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        registerPage.clickToRadioByID(driver, "gender-female");

        registerPage.enterToTextboxByID(driver, "FirstName", excelConfig.getCellData("FirstName", 1));
        registerPage.enterToTextboxByID(driver, "LastName", excelConfig.getCellData("LastName", 1));
        registerPage.enterToTextboxByID(driver, "Email", emailAddress);
        registerPage.enterToTextboxByID(driver, "Company", excelConfig.getCellData("Company", 1));

        registerPage.clickToCheckBoxByID(driver, "Newsletter");

        registerPage.enterToTextboxByID(driver, "Password", excelConfig.getCellData("Password",1));
        registerPage.enterToTextboxByID(driver, "ConfirmPassword", excelConfig.getCellData("Password",1));

        registerPage.clickButtonByText(driver,"Register");

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");

        registerPage.clickToLogoutLinkAtUserSite(driver);
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }


    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", excelConfig.getCellData("Password",1));

        loginPage.clickButtonByText(driver, "Log in");

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }


    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class,driver);

        Assert.assertTrue(customerPage.isGenderMaleSelected(driver, "gender-female"));

        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "FirstName"),excelConfig.getCellData("FirstName", 1));
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "LastName"),excelConfig.getCellData("LastName", 1));
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "Email"),emailAddress);
        Assert.assertEquals(customerPage.getTextboxValueByID(driver, "Company"),excelConfig.getCellData("Company", 1));

        Assert.assertTrue(customerPage.isNewletterCheckboxSelected(driver, "Newsletter"));
    }



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserCustomerInforPageObject customerPage;
    OrderPageObject orderPage;
    RewardPointPageObject rewardPointPage;
    AddressPageObject addressPage;


    private ExcelConfig excelConfig;


}
