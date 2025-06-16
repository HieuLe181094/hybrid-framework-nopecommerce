package pageUIs.ngoaingu24h;

import pageObjects.ngoaingu24h.PageGenerator;

public class LoginPageUI {
    public static final String OPEN_REGISTER_POPUP = "Xpath=//button[contains(text(),'Đăng ký')]";
    public static final String REGISTER_BUTTON_ON_REGISTER_POPUP = "Xpath=//button[contains(@class,'MuiButtonBase')]/ancestor::form[@class='form-auth']";
    public static final String EMAIL_ERROR_MESSAGE = "Xpath=//input[@autocomplete='email']/parent::div/following-sibling::div";
    public static final String CLOSE_ICON_ON_REGISTER_POPUP = "Xpath=//button[contains(@class,'close-btn css-100vahc')]";
}
