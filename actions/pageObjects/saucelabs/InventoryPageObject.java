package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPageObject extends BasePage {
    private WebDriver driver;

    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropdown(String sortItem) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemDropdown(driver, InventoryPageUI.SORT_DROPDOWN, sortItem);
        sleepInSecond(3);
    }

    // Java 7 trở xuống
    public boolean isNameSortAscending() {
        // Khai báo 1 List Element để lưu trữ hết các product name
        List<WebElement> productNameElement = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME);

        // Khai báo 1 List String để lưu trữ các product name (text)
        List<String> productNameText = new ArrayList<String>();

        // Dùng vòng lặp để lấy hết product name ra và thêm nó vào productNameText
        for (WebElement productName: productNameElement){
            System.out.println(productName.getText());
            productNameText.add(productName.getText());
        }

        // Sao chép toàn bộ text từ product name text qua 1 List mới
        List<String> productNameTextClone = new ArrayList<>(productNameText);

        // Sort List đã được clone
        Collections.sort(productNameTextClone);

        System.out.println("Sau khi SORT");
        for (String text: productNameTextClone){
            System.out.println(text);
        }

        // Kiểm tra 2 list bằng nhau
        return productNameTextClone.equals(productNameText);
    }

    public boolean isNameSortDescending() {
        List<WebElement> productNameElement = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName: productNameElement){
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);

        return productNameTextClone.equals(productNameText);
    }


    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElement = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();

        System.out.println("Trước khi SORT");
        for (WebElement productPrice: productPriceElement){
            System.out.println(productPrice.getText());
            productPriceText.add(Float.valueOf(productPrice.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);
        for (Float price: productPriceTextClone){System.out.println(price); }

        return productPriceTextClone.equals(productPriceText);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElement = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();

        for (WebElement productPrice: productPriceElement){
            System.out.println(productPrice.getText());
            productPriceText.add(Float.valueOf(productPrice.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);

        return productPriceTextClone.equals(productPriceText);
    }
}

