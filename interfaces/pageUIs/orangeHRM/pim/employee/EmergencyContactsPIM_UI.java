package pageUIs.orangeHRM.pim.employee;

public class EmergencyContactsPIM_UI {
    public static final String ADD_BUTTON_AT_ASSIGNED_EMERGENCY_CONTACT_CONTAINER = "Xpath=//h6[text()='Assigned Emergency Contacts']/following-sibling::button[contains(string(),'Add')]";

    public static final String NAME_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER = "Xpath=//label[text()='Name']/parent::div/following-sibling::div//input";
    public static final String RELATIONSHIP_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER = "Xpath=//label[text()='Relationship']/parent::div/following-sibling::div//input";
    public static final String HOME_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER = "Xpath=//label[text()='Home Telephone']/parent::div/following-sibling::div//input";
    public static final String MOBILE_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER  = "Xpath=//label[text()='Mobile']/parent::div/following-sibling::div//input";
    public static final String WORK_TELEPHONE_TEXTBOX_AT_EMERGENCY_CONTACT_CONTAINER  = "Xpath=//label[text()='Work Telephone']/parent::div/following-sibling::div//input";

    public static final String SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER = "Xpath=//h6[text()='Save Emergency Contact']/following-sibling::form//button[contains(string(),'Save')]";

    public static final String COLUMN_NUMBER_BY_COLUMN_NAME = "Xpath=//h6[text()='Assigned Emergency Contacts']/parent::div/parent::div/following-sibling::div[@class='orangehrm-container']//div//div[text()='%s']/parent::div//div/preceding-sibling::div";

}
