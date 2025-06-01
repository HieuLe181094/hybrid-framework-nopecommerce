package pageUIs.jQuery;

public class HomePageUI {
    // https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
    public static final String PAGINATION_PAGE_BY_NUMBER = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "Xpath=//li[@class='qgrd-pagination-page']/a[contains(@class,'active') and text()='%s']";
    public static final String PAGINATION_ALL_PAGE = "Css=li.qgrd-pagination-page";
    public static final String ALL_ROW_BY_COLUMN_NAME = "Xpath=//table/tbody//tr/td[%s]";
    public static final String COLUMN_NUMBER_BY_COLUMN_NAME = "Xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String COLUMN_TEXTBOX_BY_COLUMN_NAME = "Xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DELETE_ICON_BY_COUNTRY_NAME = "Xpath=//td[text()='%s']/preceding-sibling::td/button[contains(@class,'remove')]";
    public static final String EDIT_ICON_BY_COUNTRY_NAME = "Xpath=//td[text()='%s']/preceding-sibling::td/button[contains(@class,'edit')]";

    // https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
    public static final String LOAD_DATA_BUTTON = "Css=button#load";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "Xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "Xpath=//tr[%s]/td[%s]/input";
    public static final String CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX = "Xpath=//tr[%s]/td[%s]/div/select";
    public static final String CELL_CHECKBOX_BY_COLUMN_AND_ROW_INDEX = "Xpath=//tr[%s]/td[%s]/label/input";
    public static final String ACTION_ICON_BY_ROW_INDEX = "Xpath=//tr[%s]//button[starts-with(@title,'%s')]";

    // https://datatables.net/
    public static final String SEARCH_TEXTBOX = "Css=input#dt-search-0";
    public static final String PAGINATION_PAGE_BY_NUMBER_NEW_YORK = "Xpath=//nav[@aria-label='pagination']/button[not(contains(@class,'first')) and not (contains(@class,'last')) and not (contains(@class,'previous')) and not (contains(@class,'next'))]";
    public static final String COLUMN_NUMBER_BY_COLUMN_NAME_NEW_YORK = "Xpath=//th[contains(@class,'dt-orderable')]/div[@class='dt-column-header' and span[contains(text(),'%s')]]//ancestor::th/preceding-sibling::th";
    public static final String ALL_ROW_CONTAIN_RESULT = "Xpath=//table[@id='example']/tbody//tr/td[%s]";

    // https://blueimp.github.io/jQuery-File-Upload/
    public static final String UPLOAD_FILE_TYPE = "Css=input[type = 'file']";
    public static final String FILE_LOADED_BY_FILE_NAME = "Xpath=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "Css=td>button.start";
    public static final String FILE_UPLOADED_SUCCESS_BY_FILE_NAME = "Xpath=//p[@class='name']/a[@title='%s']";





}