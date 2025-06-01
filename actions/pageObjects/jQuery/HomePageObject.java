package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String number) {
        waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, number);
        clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, number);
        sleepInSecond(1);
    }

    public boolean isPageActivedByNumber(String number) {
        // WebDriver driver,String locator, String attributeName, String attributeValue, String... restParam
        waitForElementAttributeContain(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, "class", "active", number);
        return getElementAttribute(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, "class", number).endsWith("active");

    }

    public boolean isPageActiveByNumber(String number) {
        waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, number);
        return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, number);
    }

    public void switchToAllPage() {
        List<WebElement> allPage = getListWebElement(driver, HomePageUI.PAGINATION_ALL_PAGE);

        for (WebElement page: allPage){
            page.click();
            sleepInSecond(2);
        }
    }

    // Rest Parameter

    public void enterToColumnByName(String columnName, String searchKeyword) {
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_COLUMN_NAME, columnName);
        sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_COLUMN_NAME, searchKeyword, columnName);
        sendkeyBoardToElement(driver,HomePageUI.COLUMN_TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, columnName );
    }

    public void clickToDeleteIconByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DELETE_ICON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DELETE_ICON_BY_COUNTRY_NAME, countryName);
    }

    public void clickToEditIconByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.EDIT_ICON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.EDIT_ICON_BY_COUNTRY_NAME, countryName);
    }

    public void enterToTextBoxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSendkey) {
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;

        waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
        sendkeyToElement(driver, HomePageUI.CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, valueToSendkey, rowIndex, String.valueOf(columnIndex));
    }


    public void selectDropdownByColumnNameAndRow(String columnName, String rowIndex, String valueToSelect) {
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitForElementClickable(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
        selectItemDropdown(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, valueToSelect, rowIndex, String.valueOf(columnIndex) );

    }

    public void checkToCheckBoxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;

        waitForElementClickable(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
        checkToCheckboxRadio(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
    }

    public void uncheckToCheckBoxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;

        waitForElementClickable(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
        uncheckToCheckboxRadio(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex) );
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void clickToIconByRowIndexAndActionName(String rowIndex, String actionName) {
        waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_ROW_INDEX, rowIndex, actionName);
        clickToElement(driver, HomePageUI.ACTION_ICON_BY_ROW_INDEX, rowIndex, actionName);
    }

    public List<String> getAllRowValueAtColumnName(String columnName) {
        // Duyệt qua tất cả các page
        // 24 pages
        List<WebElement> allPage = getListWebElement(driver, HomePageUI.PAGINATION_ALL_PAGE);
        List<String> expectedAllRowValue = new ArrayList<String>();
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_NUMBER_BY_COLUMN_NAME, columnName) +1;

        // Dùng vòng lặp để duyệt qua từng page
        for (WebElement page: allPage){
            page.click();
            sleepInSecond(2);

            // Duyệt qua tất cả các row tại page hiện tại lấy hết dữ liệu tại côt cho trước
            List<WebElement> allRow = getListWebElement(driver, HomePageUI.ALL_ROW_BY_COLUMN_NAME, String.valueOf(columnIndex));

            // Dùng vòng lặp để getText từng row đưa vào 1 ArrayList
            for (WebElement row: allRow){
                expectedAllRowValue.add(row.getText());
            }
        }

        return  expectedAllRowValue;
    }

    public void showRowData(List<String> rowData){
        System.out.println("==================================================");
        for (String data: rowData){
            System.out.println(data);
        }
        System.out.println("==================================================");
    }

    public void enterToSearchTextbox(String value) {
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX,value);
    }


    public boolean isPageContain(List<String> expectedData, String value) {
        for (String data: expectedData){
            if (!data.contains(value))
                return false;
        }
        return true;
    }

    public List<String> getAllRowContainResult(String columnName) {
        List<WebElement> allPageContainResult = getListWebElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_NEW_YORK);
        System.out.println("All Page Contain Result = " +allPageContainResult.size());

        List<String> expectedAllRowContainResult = new ArrayList<String>();
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_NUMBER_BY_COLUMN_NAME_NEW_YORK, columnName) + 1;
        System.out.println("Column Index = " + columnIndex);

        for (WebElement page: allPageContainResult){
            page.click();
            sleepInSecond(2);

            // Duyệt qua tất cả các row tại page hiện tại lấy hết dữ liệu tại côt cho trước
            List<WebElement> allRowContainResult = getListWebElement(driver, HomePageUI.ALL_ROW_CONTAIN_RESULT, String.valueOf(columnIndex));
            System.out.println("All Row Contain Result = " + allRowContainResult.size());

            // Dùng vòng lặp để getText từng row đưa vào 1 ArrayList
            for (WebElement row: allRowContainResult){
                System.out.println(row.getText());
                expectedAllRowContainResult.add(row.getText());
            }
        }
        return expectedAllRowContainResult;
    }


    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
    }

    public void clickToUpLoadButton(WebDriver driver) {
        // Chỉ click đc 1 button
        // waitForElementClickable(driver, HomePageUI.UPLOAD_BUTTON);
        // clickToElement(driver, HomePageUI.UPLOAD_BUTTON);

        List<WebElement> startButtons = getListWebElement(driver, HomePageUI.UPLOAD_BUTTON);
        for (WebElement startButton : startButtons){
            startButton.click();
            sleepInSecond(3);
        }
    }

    public boolean isFileUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
    }
}
