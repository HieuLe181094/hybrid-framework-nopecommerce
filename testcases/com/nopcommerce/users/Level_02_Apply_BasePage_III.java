package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Apply_BasePage_III extends BasePage {
    WebDriver driver;
    String emailAddress;



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";



        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        openPageUrl(driver,"http://localhost/");

    }

    @Test
    public void TC_01_Register_Empty_Data() {
        clickToElement(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
//        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","FC");
        sendkeyToElement(driver,"//input[@id='Email']","123@456#%*");
        sendkeyToElement(driver,"//input[@id='Password']","123456");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Please enter a valid email address.");
    }

    @Test
    public void TC_03_Register_Success() {
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","FC");
        sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']","123456");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");

        clickToElement(driver,"//a[@class='ico-logout']");
    }

    @Test
    public void TC_04_Register_Existing_Email() {
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","FC");
        sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']","123456");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//div[@class='message-error]/li"),"Your registration completed");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","FC");
        sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']","123");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123");

        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"),
                "Password must meet the following rules: must have at least 6 characters and not greater than 64 characters");
    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","FC");
        sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']","123456");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","654321");

        clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }







}
