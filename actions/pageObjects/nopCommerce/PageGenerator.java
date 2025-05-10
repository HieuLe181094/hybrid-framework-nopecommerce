package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class PageGenerator {

    public static <T extends BasePage> T getPageInstance(Class<T> pageClass, WebDriver driver){
        try {
            // Lấy constructor nhận WebDriver
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            // Tạo instance mới của page class
            return constructor.newInstance(driver);
        } catch (Exception e){
            throw new RuntimeException("Can not init page class" + pageClass.getSimpleName(),e);
        }
    }

    // Viết các đoạn khởi tạo Page Object class thành các hàm (tái sử dụng) + tính chất đóng gói
    // Gọi qua các Re-Usable Method trong Page Generator này
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static CustomerInforPageObject getCustomerInfoPage(WebDriver driver){
        return new CustomerInforPageObject(driver);
    }
}
