package pageUIs.orangeHRM.pim.employee;

public class DependentsPIM_UI {
    public static final String ADD_BUTTON_AT_ASSIGNED_DEPENDENT_CONTAINER = "Xpath=//h6[text()='Assigned Dependents']/following-sibling::button[contains(string(),'Add')]";

    public static final String NAME_TEXTBOX_AT_DEPENDENT_CONTAINER = "Xpath=//label[text()='Name']/parent::div/following-sibling::div//input";

    public static final String RELATIONSHIP_DROPDOWN_PARENT = "Xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div/i";
    public static final String RELATIONSHIP_DROPDOWN_CHILDREN = "Xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div/div/div/span";
    public static final String RELATIONSHIP_DROPDOWN_ITEM_SELECTED_IS_CHILD = "Xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div/div/div[text()='Child']";
    public static final String RELATIONSHIP_DROPDOWN_ITEM_SELECTED_IS_OTHER = "Xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div/div/div[text()='Other']";

    public static final String PLEASE_SPECIFY_TEXTBOX_AT_DEPENDENT_CONTAINER = "Xpath=//label[text()='Please Specify']/parent::div/following-sibling::div//input";
    public static final String DATE_OF_BIRTH_TEXTBOX_AT_DEPENDENT_CONTAINER = "Xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";

    public static final String SAVE_BUTTON_AT_DEPENDENT_CONTAINER = "Xpath=//h6[text()='Add Dependent']/following-sibling::form//button[contains(string(),'Save')]";

}
