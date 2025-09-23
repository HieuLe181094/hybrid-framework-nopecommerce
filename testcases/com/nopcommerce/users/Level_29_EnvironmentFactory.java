package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.UserLoginPageObject;
import utilities.EnvironmentConfig;


public class Level_29_EnvironmentFactory extends BaseTest {
    EnvironmentConfig serverConfig;

    @Parameters({"server", "environment", "osName", "osVersion","browserName", "browserVersion"})
    @BeforeClass
    public void beforeClass(String serverName, String environmentName, @Optional("Window") String osName, @Optional("11") String osVersion,
                             @Optional("chrome") String browserName, @Optional("localhost") String browserVersion)  {
        ConfigFactory.setProperty("environment", serverName);
        serverConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriver(environmentName, serverConfig.getAppUrl(), osName, osVersion, browserName, browserVersion);

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
