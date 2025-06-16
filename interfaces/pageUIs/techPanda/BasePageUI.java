package pageUIs.techPanda;

import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;

public class BasePageUI {
    // Home Page
    public static final String ACCOUNT_AT_HEADER = "Xpath=//div[@class='account-cart-wrapper']/a/span[text()='Account']";
    public static final String MY_ACCOUNT_AT_HEADER = "Xpath=//div[@id='header-account']/div/ul/li/a[@title='My Account']";
    public static final String LOGIN_AT_HEADER = "Xpath=//div[@id='header-account']/div/ul/li/a[@title='Log In']";

    // Login Page
    public static final String MY_ACCOUNT_AT_FOOTER = "Xpath=//div[@class='footer']/div[@class='links']/ul/li[@class='first']/a[@title='My Account']";
    public static final String LOGIN_BUTTON = "Css=button#send2.button.validation-passed";
    public static final String EMAIL_ERROR_MESSAGE = "Xpath=//div[@id='advice-required-entry-email']";



}
