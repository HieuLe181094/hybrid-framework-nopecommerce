package pageObjects.nopCommerce.sideBar;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.sideBar.CustommerPageUI;

public class UserCustomerInforPageObject extends SideBarPageObject {
    WebDriver driver;

    public UserCustomerInforPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,CustommerPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustommerPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver,CustommerPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustommerPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getEmailAddressTextboxValue() {
        waitForElementVisible(driver,CustommerPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver,CustommerPageUI.EMAIL_TEXTBOX,"value");
    }


}



