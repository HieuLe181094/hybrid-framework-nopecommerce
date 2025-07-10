package pageUIs.orangeHRM.pim.employee;

public class ContactDetailsPIM_UI {
    public static final String STREET1_TEXTBOX = "Xpath=//label[text()='Street 1']/parent::div/following-sibling::div//input";
    public static final String STREET2_TEXTBOX = "Xpath=//label[text()='Street 2']/parent::div/following-sibling::div//input";
    public static final String CITY_TEXTBOX = "Xpath=//label[text()='City']/parent::div/following-sibling::div//input";
    public static final String STATE_TEXTBOX = "Xpath=//label[text()='State/Province']/parent::div/following-sibling::div//input";
    public static final String ZIPCODE_TEXTBOX = "Xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div//input";
    public static final String COUNTRY_DROPDOWN_PARENT = "Xpath=//label[text()='Country']/parent::div/following-sibling::div//div/i";
    public static final String COUNTRY_DROPDOWN_CHILD = "Xpath=//label[text()='Country']/parent::div/following-sibling::div//div/div/div/span";
    public static final String COUNTRY_DROPDOWN_ITEM_SELECTED = "Xpath=//label[text()='Country']/parent::div/following-sibling::div//div/div/div[@class='oxd-select-text-input']";
    public static final String TELEPHONE_NUMBER_HOME_TEXTBOX = "Xpath=//label[text()='Home']/parent::div/following-sibling::div//input";
    public static final String TELEPHONE_NUMBER_MOBILE_TEXTBOX = "Xpath=//label[text()='Mobile']/parent::div/following-sibling::div//input";
    public static final String TELEPHONE_NUMBER_WORK_TEXTBOX = "Xpath=//label[text()='Work']/parent::div/following-sibling::div//input";
    public static final String WORK_EMAIL_TEXTBOX = "Xpath=//label[text()='Work Email']/parent::div/following-sibling::div//input";
    public static final String OTHER_EMAIL_TEXTBOX = "Xpath=//label[text()='Other Email']/parent::div/following-sibling::div//input";

    public static final String SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER = "Xpath=//h6[text()='Contact Details']/following-sibling::form//button[contains(string(),'Save')]";



}
