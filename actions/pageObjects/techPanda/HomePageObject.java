package pageObjects.techPanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techPanda.BasePageUI;

public class HomePageObject extends BasePage {


    WebDriver driver;

    public HomePageObject(WebDriver driver){this.driver = driver;}

    public void clickToAccountAtHeader() {
        waitForElementClickable(driver, BasePageUI.ACCOUNT_AT_HEADER);
        clickToElement(driver, BasePageUI.ACCOUNT_AT_HEADER);
    }

    public boolean isMyAccountDisplayed() {
        return isElementDisplayed(driver, BasePageUI.MY_ACCOUNT_AT_HEADER);
    }

    public void clickToLogInAtHeader() {
        waitForElementClickable(driver, BasePageUI.LOGIN_AT_HEADER);
        clickToElement(driver, BasePageUI.LOGIN_AT_HEADER);
    }


    public boolean isMyAccountUnDisplayed() {
        return isElementUndisplayed(driver, BasePageUI.ACCOUNT_AT_HEADER);
    }
}
