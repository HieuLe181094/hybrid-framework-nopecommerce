package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.BasePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver){
        this.driver = driver;

    }

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, BasePageUI.REGISTER_LINK);
        clickToElement(driver, BasePageUI.REGISTER_LINK);
        return PageGenerator.getPageInstance(UserRegisterPageObject.class,driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, BasePageUI.USER_LOGIN_LINK);
        clickToElement(driver, BasePageUI.USER_LOGIN_LINK);
        return PageGenerator.getPageInstance(UserLoginPageObject.class,driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, BasePageUI.USER_MY_ACCOUNT_LINK);
        return getWebElement(driver, BasePageUI.USER_MY_ACCOUNT_LINK).isDisplayed();
    }
}
