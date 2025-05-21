package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
