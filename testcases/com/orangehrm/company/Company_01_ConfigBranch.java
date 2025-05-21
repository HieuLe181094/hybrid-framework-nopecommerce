package com.orangehrm.company;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Company_01_ConfigBranch extends BaseTest {

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        getBrowserDriver(urlValue,browserName);
    }

    @Test
    public void TC_01_Login() {

    }

    @Test
    public void TC_02_New_Employee() {

    }

    @Test
    public void TC_03_Personal_Detail() {

    }



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    WebDriver driver;


}
