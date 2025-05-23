package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void enterToUserNameTextBox(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.USERNAME_TEXTBOX,userName);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }
}
