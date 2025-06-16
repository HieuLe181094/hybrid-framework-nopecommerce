package pageObjects.ngoaingu24h;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ngoaingu24h.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterButtonOnNavigation() {
        waitForElementClickable(driver, LoginPageUI.OPEN_REGISTER_POPUP);
        clickToElement(driver, LoginPageUI.OPEN_REGISTER_POPUP);
    }

    public void clickToRegisterButtonOnRegisterPopup() {
        waitForElementClickable(driver, LoginPageUI.REGISTER_BUTTON_ON_REGISTER_POPUP);
        clickToElement(driver, LoginPageUI.REGISTER_BUTTON_ON_REGISTER_POPUP);
    }

    public boolean isEmailErrorMessageDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public boolean isEmailErrorMessageUnDisplayed() {
        return isElementUndisplayed(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }


    public void clickToCloseIcon() {
        waitForElementVisible(driver, LoginPageUI.CLOSE_ICON_ON_REGISTER_POPUP);
        clickToElement(driver, LoginPageUI.CLOSE_ICON_ON_REGISTER_POPUP);
    }
}
