package pageUIs.nopCommerce;

public class BasePageUI {
    // User Site
    public static final String REWARD_POINT_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static final String ADDRESS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static final String CUSTOMER_INFO_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
    public static final String ORDER_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Orders']";

    public static final String REGISTER_LINK = "Class=ico-register";
    public static final String USER_LOGIN_LINK = "Xpath=//a[@class='ico-login']";
    public static final String USER_LOGOUT_LINK = "Xpath=//a[@class='ico-logout']";
    public static final String USER_MY_ACCOUNT_LINK = "Xpath=//a[@class='ico-account']";

    // Admin Site
    public static final String ADMIN_LOGOUT_LINK = "Xpath=//a[text()='Logout']";
    public static final String ADMIN_PRODUCT_MENU = "Xpath=//p[text()=' Products']/ancestor::li[contains(@class,'has-treeview')]";
    public static final String ADMIN_PRODUCT_SUBMENU = "Xpath=//p[text()=' Products']";


}
