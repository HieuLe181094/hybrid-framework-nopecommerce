package com.jQuery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jQuery.HomePageObject;

import java.util.ArrayList;
import java.util.List;

public class Level_13_Upload extends BaseTest {
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        homePage = PageGenerator.getPageInstance(HomePageObject.class, driver);

        body = "Body.jpg";
        heart = "Heart.jpg";
        intelligent = "Intelligent.jpg";

    }

    @Test
    public void TC_01_Upload() {
        // Lấy ra được đường dẫn của file/ thư mục cho đúng
        // Tất cả các OS: Window/ MAC/ Linux đều chạy được
        // UPLOAD_PATH


        // Có thể upload 1 lần 1 file => dùng 1 hàm
        homePage.uploadMultipleFiles(driver, body);
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);

        // Có thế upload 1 lần nhiều file => dùng 1 hàm
        homePage.uploadMultipleFiles(driver, body, heart, intelligent);
        homePage.sleepInSecond(3);

        // Verify load file lên
        Assert.assertTrue(homePage.isFileLoadedByName(body));
        Assert.assertTrue(homePage.isFileLoadedByName(heart));
        Assert.assertTrue(homePage.isFileLoadedByName(intelligent));

        // Click Upload button tại từng file
        homePage.clickToUpLoadButton(driver);

        // Có thể verify 1 file/ nhiều file được upload xong
        Assert.assertTrue(homePage.isFileUploadedByName(body));
        Assert.assertTrue(homePage.isFileUploadedByName(heart));
        Assert.assertTrue(homePage.isFileUploadedByName(intelligent));

        // Các file được sử dụng để Upload nên đẩy code lên cùng
        // Có cần care tới Open File Dialog hay ko?
        // Ko cần care - cách đang làm ko cần đụng tới Open File Dialog


    }












    @AfterClass
    public void afterClass() {
    driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private  String body, heart, intelligent;

}
