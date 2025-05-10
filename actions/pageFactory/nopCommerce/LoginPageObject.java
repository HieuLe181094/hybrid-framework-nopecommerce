package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BagePage{
    private WebDriver driver;

    @FindBy(how = How.XPATH,using ="//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(how = How.XPATH,using = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(how = How.XPATH,using ="//button[text()='Log in']" )
    private WebElement loginButton;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(passwordTextbox,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,loginButton);
        clickToElement(loginButton);
    }
}
