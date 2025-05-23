package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPageObject extends BagePage{
    private WebDriver driver;
    // 1- Định nghĩa Element trong chính Class này
    // Ko đưa ra ngoài 1 Class khác/ package khác

    @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(how = How.ID,using = "LastName")
    private WebElement lastNameTextbox;

    @FindBy(how = How.CSS,using ="input[id='Email']")
    private WebElement emailTextbox;

    @FindBy(how = How.XPATH,using = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(how = How.XPATH,using = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextbox;

    @FindBy(how = How.XPATH,using ="//button[@id='register-button']" )
    private WebElement registerButton;

    @FindBy(how = How.XPATH,using = "//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(how = How.XPATH,using ="//a[@class='ico-logout']" )
    private WebElement loginLink;

    private List<WebElement> cityCheckboxes;

    // 2 - Init các Element lên
    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // 3 - Action nó tương tụ tên hàm như dùng vs Page Object
    // Nó sẽ thao tác vs Element/ List Element

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver,firstNameTextbox);
        sendkeyToElement(firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,lastNameTextbox);
        sendkeyToElement(lastNameTextbox,lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver,emailTextbox);
        sendkeyToElement(emailTextbox,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(passwordTextbox,password);
    }

    public void enterToConformPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,confirmPasswordTextbox);
        sendkeyToElement(confirmPasswordTextbox,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,registerButton);
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,registerSuccessMessage);
        return getElementText(registerSuccessMessage);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(loginLink);
    }


}
