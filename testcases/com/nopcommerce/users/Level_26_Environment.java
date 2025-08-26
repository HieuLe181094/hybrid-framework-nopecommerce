package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;
import utilities.PropertiesConfig;

import java.io.IOException;


public class Level_26_Environment extends BaseTest {
    EnvironmentConfig environmentConfig;

    @Parameters({"environment","browser"})
    @BeforeClass
    public void beforeClass(String environment, String browserName)  {
        ConfigFactory.setProperty("environment", environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        driver = getBrowserDriver(environmentConfig.getAppUrl(), browserName);

        System.out.println(environmentConfig.getAppUrl());
        System.out.println(environmentConfig.getAppUserName());
        System.out.println(environmentConfig.getAppPassword());
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
    private String firstName, lastName, emailAddress, companyName, password;


}
