package com.saucelabs;


import commons.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.UserHomePageObject;
import pageObjects.saucelabs.InventoryPageObject;
import pageObjects.saucelabs.LoginPageObject;
import pageObjects.saucelabs.PageGenerator;


public class Level_23_Sort extends BaseTest {

    @Parameters({"urlUser","browser"})
    @BeforeClass

    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        loginPage = PageGenerator.getLoginPage(driver);

        inventoryPage = loginPage.loginToApplication("standard_user", "secret_sauce");

    }

    //@Test
    public void Sort_01_Name() {

        inventoryPage.selectSortDropdown("Name (A to Z)");
        verifyTrue(inventoryPage.isNameSortAscending());

        inventoryPage.selectSortDropdown("Name (Z to A)");
        verifyTrue(inventoryPage.isNameSortDescending());

    }


    @Test
    public void Sort_02_Price() {
        inventoryPage.selectSortDropdown("Price (low to high)");
        verifyTrue(inventoryPage.isPriceSortAscending());

        inventoryPage.selectSortDropdown("Price (high to low)");
        verifyTrue(inventoryPage.isPriceSortDescending());

    }

    @Test
    public void Sort_03_Date() {

    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }


    private WebDriver driver;
    private LoginPageObject loginPage;
    private InventoryPageObject inventoryPage;


}
