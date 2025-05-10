package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.nopCommerce.CustommerPageUI;

public class CustomerInfoPageObject extends BagePage {
    private WebDriver driver;

    @FindBy(how = How.XPATH,using = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(how = How.XPATH,using = "//input[@id='LastName']")
    private WebElement lastNameTextBox;

    @FindBy(how = How.XPATH,using = "//input[@id='Email']")
    private WebElement emailTextbox;

    public CustomerInfoPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,firstNameTextbox);
        return getElementAttribute(firstNameTextbox,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver,lastNameTextBox);
        return getElementAttribute(lastNameTextBox,"value");
    }

    public String getEmailAddressTextboxValue() {
        waitForElementVisible(driver,emailTextbox);
        return getElementAttribute(emailTextbox,"value");
    }
}
