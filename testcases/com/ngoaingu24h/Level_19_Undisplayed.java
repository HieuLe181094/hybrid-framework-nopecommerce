package com.ngoaingu24h;


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
import pageObjects.ngoaingu24h.LoginPageObject;
import pageObjects.ngoaingu24h.PageGenerator;

@Feature("User")
public class Level_19_Undisplayed extends BaseTest {

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @Test
    public void TC_01_Element_Dislayed() {
        loginPage.clickToRegisterButtonOnNavigation();
        loginPage.sleepInSecond(3);

        loginPage.clickToRegisterButtonOnRegisterPopup();
        loginPage.sleepInSecond(3);

        // Case 1 - Verify Email Error Message is displayed
        Assert.assertTrue(loginPage.isEmailErrorMessageDisplayed());

        // Case 2 - Verify Email Error Message is not displayed
        loginPage.sleepInSecond(3);
        Assert.assertFalse(loginPage.isEmailErrorMessageDisplayed());

        // Case 3 - Verify Email Error Message is not displayed
        loginPage.clickToCloseIcon();
        loginPage.sleepInSecond(3);
        Assert.assertTrue(loginPage.isEmailErrorMessageUnDisplayed());

        // findElement should not be used to look for non-present elements
        // Use findElements(By) and assert zero lenght respone instead.
    }

    @Test
    public void TC_02_Element_Undisplayed() {
        loginPage.clickToRegisterButtonOnNavigation();
        loginPage.sleepInSecond(3);

        loginPage.clickToRegisterButtonOnRegisterPopup();
        loginPage.sleepInSecond(3);

        // Case 1 - Verify Email Error Message is displayed
        Assert.assertFalse(loginPage.isEmailErrorMessageUnDisplayed());

        // Case 2 - Verify Email Error Message is not displayed
        loginPage.sleepInSecond(3);
        Assert.assertTrue(loginPage.isEmailErrorMessageUnDisplayed());

        // Case 3 - Verify Email Error Message is not displayed
        loginPage.clickToCloseIcon();
        loginPage.sleepInSecond(3);
        Assert.assertTrue(loginPage.isEmailErrorMessageUnDisplayed());

        // findElement should not be used to look for non-present elements
        // Use findElements(By) and assert zero lenght respone instead.
    }




    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    private WebDriver driver;
    private LoginPageObject loginPage;

}
