package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConformPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver,RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver,RegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getPageInstance(HomePageObject.class,driver);
    }
}
