package pageUIs.nopCommerce;

public class BasePageUI {
    // User Site
    public static final String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static final String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static final String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
    public static final String ORDER_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Orders']";

    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String USER_LOGIN_LINK = "//a[@class='ico-login']";
    public static final String USER_LOGOUT_LINK = "//a[@class='ico-logout']";
    public static final String USER_MY_ACCOUNT_LINK = "//a[@class='ico-account']";

    // Admin Site
    public static final String ADMIN_LOGOUT_LINK = "//a[text()='Logout']";
    public static final String ADMIN_PRODUCT_MENU = "//p[text()=' Products']/ancestor::li[contains(@class,'has-treeview')]";
    public static final String ADMIN_PRODUCT_SUBMENU = "//p[text()=' Products']";


}
