package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPagePIM_UI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void enterToUserNameTextBox(String userName) {
       waitForElementVisible(driver, LoginPagePIM_UI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPagePIM_UI.USERNAME_TEXTBOX,userName);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPagePIM_UI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPagePIM_UI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitForElementVisible(driver, LoginPagePIM_UI.LOGIN_BUTTON);
        clickToElement(driver, LoginPagePIM_UI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPageInstance(DashboardPageObject.class,driver);
    }
}
