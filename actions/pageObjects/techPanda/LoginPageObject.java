package pageObjects.techPanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techPanda.BasePageUI;


public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){this.driver = driver;}

    public boolean isMyAccountAtFooterUnDisplayed() {
        return isElementUndisplayed(driver, BasePageUI.MY_ACCOUNT_AT_FOOTER);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, BasePageUI.LOGIN_BUTTON);
        clickToElement(driver, BasePageUI.LOGIN_BUTTON);
    }

    public boolean isEmailErrorMessageUnDisplayed() {
        return isElementUndisplayed(driver, BasePageUI.EMAIL_ERROR_MESSAGE);
    }
}
