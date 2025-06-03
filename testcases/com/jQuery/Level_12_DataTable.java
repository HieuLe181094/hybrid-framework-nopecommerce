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
import pageObjects.nopCommerce.UserHomePageObject;
import pageObjects.nopCommerce.UserLoginPageObject;
import pageObjects.nopCommerce.UserRegisterPageObject;
import pageObjects.nopCommerce.sideBar.AddressPageObject;
import pageObjects.nopCommerce.sideBar.OrderPageObject;
import pageObjects.nopCommerce.sideBar.RewardPointPageObject;
import pageObjects.nopCommerce.sideBar.UserCustomerInforPageObject;

import java.util.ArrayList;
import java.util.List;

public class Level_12_DataTable extends BaseTest {
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue, String browserName) {
        driver = getBrowserDriver(urlValue,browserName);

        homePage = PageGenerator.getPageInstance(HomePageObject.class, driver);

    }

    //@Test
    public void TC_01_Paging() {
         // Chọn trang dựa vào số trang
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActivedByNumber("15"));
        Assert.assertTrue(homePage.isPageActiveByNumber("15"));

        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageActivedByNumber("10"));
        Assert.assertTrue(homePage.isPageActiveByNumber("10"));

        homePage.openPageByNumber("23");
        Assert.assertTrue(homePage.isPageActivedByNumber("23"));
        Assert.assertTrue(homePage.isPageActiveByNumber("23"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageActivedByNumber("5"));
        Assert.assertTrue(homePage.isPageActiveByNumber("5"));

        homePage.switchToAllPage();
    }

    //@Test
    public void TC_02_Search() {
        // Nhập vào 1 cột bất kì dựa vào tên cột
        // Ko quan tâm index của cột = cột nó thay đổi vị trí vẫn tìm được
        homePage.enterToColumnByName("Country", "Argentina");
        homePage.sleepInSecond(2);

        homePage.refreshCurrentPage(driver);
        homePage.enterToColumnByName("Females", "750");
        homePage.sleepInSecond(2);

        homePage.refreshCurrentPage(driver);
        homePage.enterToColumnByName("Country", "Arab Rep of Egypt");
        homePage.sleepInSecond(2);
    }

    //@Test
    public void TC_03_Action_Delete() {
        // Click vào icon Delete hoặc Edit tại bất kì row nào
        // Có từ khóa duy nhất => Country Name
        homePage.enterToColumnByName("Country", "Afghanistan");
        homePage.sleepInSecond(2);
        homePage.clickToDeleteIconByCountryName("Afghanistan");

        homePage.enterToColumnByName("Country", "Aruba");
        homePage.sleepInSecond(2);
        homePage.clickToDeleteIconByCountryName("Aruba");

        homePage.enterToColumnByName("Country", "Albania");
        homePage.sleepInSecond(2);
        homePage.clickToDeleteIconByCountryName("Albania");
    }

    //@Test
    public void TC_04_Action_Edit() {
        homePage.enterToColumnByName("Country", "Antigua and Barbuda");
        homePage.sleepInSecond(2);
        homePage.clickToEditIconByCountryName("Antigua and Barbuda");

        homePage.refreshCurrentPage(driver);
        homePage.enterToColumnByName("Country", "Aruba");
        homePage.sleepInSecond(2);
        homePage.clickToEditIconByCountryName("Aruba");
    }

    // @Test
    public void TC_05_() {
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        homePage.clickToLoadDataButton();

        homePage.enterToTextBoxByColumnNameAndRowIndex("Contact Person", "3", "Helen Grace");
        homePage.sleepInSecond(3);

        homePage.enterToTextBoxByColumnNameAndRowIndex("Company","2","Jolibee");
        homePage.sleepInSecond(3);

        homePage.selectDropdownByColumnNameAndRow("Country", "2", "Germany");
        homePage.sleepInSecond(3);

        homePage.selectDropdownByColumnNameAndRow("Country", "3", "Japan");
        homePage.sleepInSecond(3);

        homePage.checkToCheckBoxByColumnNameAndRowIndex("NPO?", "2");
        homePage.sleepInSecond(3);

        homePage.checkToCheckBoxByColumnNameAndRowIndex("NPO?", "3");
        homePage.sleepInSecond(3);

        homePage.uncheckToCheckBoxByColumnNameAndRowIndex("NPO?", "2");
        homePage.sleepInSecond(3);

        homePage.uncheckToCheckBoxByColumnNameAndRowIndex("NPO?", "3");
        homePage.sleepInSecond(3);

        // Sau khi thao tác lên 1 dòng bất kỳ (Thêm/ Xóa/ Up/ Down) thì thứ tự các dòng được cập nhật lại
        homePage.clickToIconByRowIndexAndActionName("3","Remove");
        homePage.sleepInSecond(3);

        homePage.clickToIconByRowIndexAndActionName("5", "Move Up");
        homePage.sleepInSecond(3);

        homePage.clickToIconByRowIndexAndActionName("2", "Move Down");
        homePage.sleepInSecond(3);
    }

    // @Test
    public void TC_06_Get_Data_All_Row(){
        // Actual Data (Json/ Excel/...)
        // Actual Data (Json/ Excel/...)
        List<String> actualCountry  = new ArrayList<String>();

        // Expected Data (UI)
        // Assert.assertEquals(actualCountry, expectedCountry);
        List<String> expectedCountry = homePage.getAllRowValueAtColumnName("Country");
        homePage.showRowData(expectedCountry);

        List<String> expectedTotal = homePage.getAllRowValueAtColumnName("Total");
        homePage.showRowData(expectedTotal);
    }

    //@Test
    public void TC_07_DATA_TEST(){
        String value = "New York";

        homePage.openPageUrl(driver,"https://datatables.net/");
        homePage.sleepInSecond(2);

        // Input search keyword "New York"
        homePage.enterToSearchTextbox(value);
        homePage.sleepInSecond(2);

        // Verify kết quả ở các row chỉ chứa "New York"
        List<String> actualCity = new ArrayList<String>();

        List<String> expectedResult = homePage.getAllRowContainResult("Office");
        homePage.showRowData(expectedResult);

        // Tổng sô kết quả hiển thị đúng cho mỗi Page (sau khi trả về kq)

    }

    @Test
    public void TC_08_TECHPANDA(){
        homePage.openPageUrl(driver,"https://live.techpanda.org/");

        homePage.clickToAccountTechPanda(driver);
        homePage.clickToLoginLinkTechPanda(driver);

    }





    @AfterClass
    public void afterClass() {
    driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;



}
