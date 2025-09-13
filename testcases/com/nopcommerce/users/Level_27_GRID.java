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


public class Level_27_GRID extends BaseTest {
    EnvironmentConfig environmentConfig;

    @Parameters({"environment","browser", "osName", "ipAddress", "port"})
    @BeforeClass
    public void beforeClass(String environment, String browserName, String osName, String ipAddress, String portNumber)  {
        ConfigFactory.setProperty("environment", environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriver(browserName, environmentConfig.getAppUrl(), osName, ipAddress, portNumber);

        System.out.println(environmentConfig.getAppUrl());
        System.out.println(environmentConfig.getAppUserName());
        System.out.println(environmentConfig.getAppPassword());

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
