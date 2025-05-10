package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.CustommerPageUI;

public class CustomerInforPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInforPageObject(WebDriver driver) {
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
