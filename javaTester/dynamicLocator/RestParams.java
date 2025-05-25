package dynamicLocator;

public class RestParams {
    public static final String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static final String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static final String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
    public static final String ORDER_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Orders']";

    // 1 tham số Dynamic
    // public static final String DYNAMIC_SIDEBAR_LINK = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
    // public static final String DYNAMIC_SIDEBAR_LINK = "//div[contains(@class,'%s')]//a[text()='%s']";
    public static final String DYNAMIC_SIDEBAR_LINK = "//div[contains(@class,'%s')]//a[text()='%s']//span[text()='%s']";

    public static void main(String[] agrs) {
//       clickToLink(ADDRESS_LINK);
//       clickToLink(REWARD_POINT_LINK);
//       clickToLink(CUSTOMER_INFO_LINK);
//
       clickToLink(DYNAMIC_SIDEBAR_LINK, "Addresses");
       clickToLink(DYNAMIC_SIDEBAR_LINK, "Reward points");
       clickToLink(DYNAMIC_SIDEBAR_LINK, "Customer info");

//       clickToLink(DYNAMIC_SIDEBAR_LINK, "account-navigation", "Addresses");
//       clickToLink(DYNAMIC_SIDEBAR_LINK, "account-navigation", "Reward points");
//       clickToLink(DYNAMIC_SIDEBAR_LINK, "account-navigation", "Customer info");

        clickToLink(DYNAMIC_SIDEBAR_LINK,"account-navigation", "Addresses", "Login", "Success");
        clickToLink(DYNAMIC_SIDEBAR_LINK,"account-navigation", "Addresses", "Register", "Fail");
        clickToLink(DYNAMIC_SIDEBAR_LINK,"account-navigation", "Addresses", "Order", "Pass");

    }

    // Click vào link trên - tham số là Locator
//    public static void clickToLink(String locator){
//        System.out.println("Click to link = " + locator);
//    }
//
//    public static void clickToLink(String locator, String value){
//        System.out.println("Click to link = " + String.format(locator, value));
//    }
//
//    public static void clickToLink(String locator, String firstValue, String secondValue){
//        System.out.println("Click to link = " + String.format(locator, firstValue, secondValue));
//    }
//
//    public static void clickToLink(String locator, String firstValue, String secondValue, String thirdValue){
//        System.out.println("Click to link = " + String.format(locator, firstValue, secondValue, thirdValue));
//    }
//
//    public static void clickToLink(String locator, String firstValue, String secondValue, String thirdValue, String forthValue){
//        System.out.println("Click to link = " + String.format(locator, firstValue, secondValue, thirdValue, forthValue));
//    }

    // Var Argument: những tham số còn lại giống nhau về kiểu dữ liệu
    // Áp dụng được cho n tham số cùng kiểu dữ liệu
    // Nó phải nằm ở cuối cùng về mặt thứ tự tham số
    public static void clickToLink(String locator, String... value){
        System.out.println("Click to link = " + String.format(locator,(Object[]) value ));

    }

}
