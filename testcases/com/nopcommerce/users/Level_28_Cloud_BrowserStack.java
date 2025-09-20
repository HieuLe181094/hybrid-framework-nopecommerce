package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.UserLoginPageObject;
import utilities.EnvironmentConfig;


public class Level_28_Cloud_BrowserStack extends BaseTest {
    EnvironmentConfig environmentConfig;

    @Parameters({"environment", "osName", "osVersion", "browserName", "browserVersion"})
    @BeforeClass
    public void beforeClass(String environment, String osName, String osVersion, String browserName, String browserVersion)  {
        ConfigFactory.setProperty("environment", environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriverBrowserStack(environmentConfig.getAppUrl(), osName, osVersion, browserName, browserVersion);

        loginPageObject = PageGenerator.getLoginPage(driver);
    }

    @Test
    public void TC_01_Register() {

    }

    @Test
    public void TC_02_Login() {

    }

    @Test
    public void TC_03_MyAccount() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private UserLoginPageObject loginPageObject;


}
