package com.techPanda;


import commons.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.techPanda.HomePageObject;
import pageObjects.techPanda.LoginPageObject;
import pageObjects.techPanda.PageGenerator;

@Feature("User")
public class Level_19_Undisplayed extends BaseTest {

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        homePage.sleepInSecond(3);
    }

    @Description("Element_Dislayed")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_01_Element_Dislayed() {

        // Case 2 - Verify My Account Link (at Header) is not displayed (có trong HTML và KO có trên UI)
        Assert.assertFalse(homePage.isMyAccountDisplayed());

        // Case 1 - Verify My Account Link (at Header) is displayed (có trong HTML và có trên UI)
        homePage.clickToAccountAtHeader();
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isMyAccountDisplayed());

        // Case 3 - Verify My Account Link (at Header) is not displayed (KO có trong HTML và KO có trên UI)
        homePage.clickToLogInAtHeader();
        homePage.sleepInSecond(2);
        Assert.assertFalse(homePage.isMyAccountDisplayed());

        // findElement should not be used to look for non-present elements
        // Use findElements(By) and assert zero lenght respone instead.
    }

    @Description("Element_Undisplayed")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_02_Element_Undisplayed() {
        loginPage = PageGenerator.getLoginPage(driver);
//        loginPage.sleepInSecond(3);

        // Case 1 - Verify My Account Link (at Footer) is displayed (có trong HTML và có trên UI)
        Assert.assertFalse(loginPage.isMyAccountAtFooterUnDisplayed());

        // Case 2 - Verify Error Email Message is not displayed (có trong HTML và KO có trên UI)
        loginPage.clickToLoginButton();
        loginPage.sleepInSecond(3);
        Assert.assertFalse(loginPage.isEmailErrorMessageUnDisplayed());

        // Case 3 - Verify Error Email Message is not displayed (KO có trong HTML và KO có trên UI)
        loginPage.refreshCurrentPage(driver);
        loginPage.sleepInSecond(2);
        Assert.assertTrue(loginPage.isEmailErrorMessageUnDisplayed());

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

}
