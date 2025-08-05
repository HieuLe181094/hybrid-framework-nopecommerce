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
       selectItemDropdown(driver, InventoryPageUI.PRODUCT_NAME, sortItem);
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
}
