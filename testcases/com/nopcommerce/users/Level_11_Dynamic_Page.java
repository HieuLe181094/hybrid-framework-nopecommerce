package com.nopcommerce.users;

import commons.BaseTest;
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

public class Level_11_Dynamic_Page extends BaseTest {
    @Parameters({"urlUser","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        firstName = "Marley";
        lastName = "Grollmann";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        companyName ="Twiyo";
        password = "gK3@*09`%NO";

        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);

    }

    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();

        // Về mặt Business thì khi chưa đăng ký thì ko có xuất hiện
        // Customer Info Page được
//        registerPage.openCustomerPage(driver);

        // Về mặt Coding thì nó chưa ràng buộc
        // Vẫn gọi code ra được

//        loginPage.openRewardPointPage(driver);
//        loginPage.openOrderPage(driver);


        registerPage = PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConformPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLinkAtUserSite(driver);

        // Về lại trang Home: từ page A qua page B
        // RegisterPage qua HomePage
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @Test
    public void TC_02_Login() {
        homePage.clickToLoginLink();

        // Từ page A qua page B
        // Từ Home qua Login
        loginPage = PageGenerator.getPageInstance(UserLoginPageObject.class,driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

//        loginPage.loginToSystem(emailAddress,password);
//        loginPage.clickToLoginButton();

        // Từ page A qua lại page B
        // Tù Login về Home
        homePage = PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }

    @Test
    public void TC_03_MyAccount() {
        homePage.clickToMyAccountLinkAtUserSite(driver);

        // Từ page A qua page B
        // Từ Login về CustomerInfo
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class,driver);

        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxValue(),emailAddress);
    }

    @Test
    public void TC_04_SwitchPage_Hard_Code(){
        // Customer -> Address
        // ...
        addressPage = customerPage.openAddressPage(driver);
        System.out.println(addressPage.toString());

        // Address -> Reward Point
        // ...
        rewardPointPage = addressPage.openRewardPointPage(driver);
        System.out.println(registerPage.toString());

        // Reward Point -> Order
        // ...
        orderPage = rewardPointPage.openOrderPage(driver);
        System.out.println(orderPage.toString());

        // Order -> Customer
        // ...
        customerPage = orderPage.openCustomerPage(driver);
        System.out.println(customerPage.toString());

        // Customer -> Reward Point
        rewardPointPage = customerPage.openRewardPointPage(driver);
        System.out.println(rewardPointPage.toString());

        // Order -> Address
        addressPage = orderPage.openAddressPage(driver);

        // Address -> Order
        orderPage = addressPage.openOrderPage(driver);

    }

    @Test
    public void TC_05_SwitchPage_Dynamic_Page_Name_01(){
        // Customer -> Address
        // ...
        addressPage = (AddressPageObject) customerPage.openSideBarByPageName("Addresses");

        // Address -> Reward Point
        // ...
        rewardPointPage = (RewardPointPageObject) addressPage.openSideBarByPageName("Reward points");


        // Reward Point -> Order
        // ...
        orderPage = (OrderPageObject) rewardPointPage.openSideBarByPageName("Orders");

        // Order -> Customer
        // ...
        customerPage = (UserCustomerInforPageObject) orderPage.openSideBarByPageName("Customer info");


        // Customer -> Reward Point
        rewardPointPage = (RewardPointPageObject) customerPage.openSideBarByPageName("Reward points");


        // Order -> Address
        addressPage = (AddressPageObject) orderPage.openSideBarByPageName("Addresses");

        // Address -> Order
        orderPage = (OrderPageObject) addressPage.openSideBarByPageName("Orders");

    }

    @Test
    public void TC_06_SwitchPage_Dynamic_Page_Name_02(){
        // Customer -> Address
        // ...
        orderPage.openSideBar("Addresses");
        addressPage = PageGenerator.getPageInstance(AddressPageObject.class, driver);

        // Address -> Reward Point
        // ...
        addressPage.openSideBar("Reward points");
        rewardPointPage = PageGenerator.getPageInstance(RewardPointPageObject.class, driver);


        // Reward Point -> Order
        // ...
        rewardPointPage.openSideBar("Orders");
        orderPage = PageGenerator.getPageInstance(OrderPageObject.class, driver);

        // Order -> Customer
        // ...
        orderPage.openSideBar("Customer info");
        customerPage = PageGenerator.getPageInstance(UserCustomerInforPageObject.class, driver);

        // Customer -> Reward Point
        customerPage.openSideBar("Reward points");
        rewardPointPage = PageGenerator.getPageInstance(RewardPointPageObject.class, driver);

        // Order -> Address
        orderPage.openSideBar("Addresses");
        addressPage = PageGenerator.getPageInstance(AddressPageObject.class, driver);

        // Address -> Order
        addressPage.openSideBar("Orders");
        orderPage = PageGenerator.getPageInstance(OrderPageObject.class, driver);

    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserRegisterPageObject registerPage;
    UserCustomerInforPageObject customerPage;
    OrderPageObject orderPage;
    RewardPointPageObject rewardPointPage;
    AddressPageObject addressPage;
    String firstName, lastName, emailAddress, companyName, password;

}
