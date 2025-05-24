package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;

public class Locator {
    public static void main (String[] args) {
        // Yêu cầu:
        // - Truyền vào giá trị của Locator: Css Xpath ID Name Class
        // - Trả về kiểu By tương ứng vs tham số truyền vào
        // - Nếu truyền sai thì trả về Exception
        // - Nếu truyền đúng như giá trị null/ empty thì sẽ thông báo lỗi

        // //a[@class='ico-register'] => Xpath=//a[@class='ico-register']
        // a.ico-register => Css=a.ico-register
        // ico-register => Class=ico-register

        getByLocator("Xpath=//a[@class='ico-register' and @id='register']");
        getByLocator("Css=a[class='ico-register']");
        getByLocator("Css=a.ico-register");
        getByLocator("Class=ico-register");

    }


    public static By getByLocator (String locator) {

        if (locator.isEmpty() || locator == null ){
            throw new RuntimeException("Locator type cannot be null or empty");

        }

        switch (locator.split("=")[0].toLowerCase()){
            case "xpath":
                return By.xpath(locator.substring(6));
            case "css":
                return By.cssSelector(locator.substring(4));
            case "id":
                return By.id(locator.substring(3));
            case "class":
                return By.className(locator.substring(6));
            case "name":
                return By.name(locator.substring(5));
            default:
                throw new IllegalArgumentException("Locator type is not support.");
        }
    }
}
