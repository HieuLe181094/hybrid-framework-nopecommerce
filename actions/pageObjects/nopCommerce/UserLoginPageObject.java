package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.LoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

//    public LoginPageObject loginToSystem(String emailAddress, String password){
//        enterToEmailTextbox(emailAddress);
//        enterToPasswordTextbox(password);
//        clickToLoginButton();
//        return new LoginPageObject(driver);
//    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPageInstance(UserHomePageObject.class,driver);
    }
}
