package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BagePage{
    private WebDriver driver;

    @FindBy(how = How.XPATH,using = "//a[@class='ico-register']")
    private WebElement registerLink;

    @FindBy(how = How.XPATH,using = "//a[@class='ico-login']" )
    private WebElement loginLink;

    @FindBy(how = How.XPATH,using = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver,registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(loginLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(myAccountLink);
    }
}
