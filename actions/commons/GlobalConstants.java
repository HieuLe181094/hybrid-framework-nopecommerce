package commons;

public class GlobalConstants {
    // HẰNG SỐ
    // static final: Java
    // public: access modifier vì nó tính chất toàn cục
    // Luôn viết hoa - nếu có nhiều từ thì phân cách bởi dấu _

    // Short/ Long Timeout
    public static  final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    // App Server Url
    public static final String DEV_URL = "http://localhost/";
    public static final String TEST_URL = "http://test.localhost/";
    public static final String LIVE_URL = "http://live.localhost/";

    // OS Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");

    // Admin User/ Pass
    public static final String ADMIN_USERNAME = "hiuhiu@gmail.com";
    public static final String ADMIN_PASSWORD = "hiuhiu@gmail.com";

    // Upload/ Download
    public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/";
    public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";

    // Browser Logs/ Extension
    public  static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
    public  static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";

    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + "/htmlReportNG/";
    public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
    public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";

    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + "/dataTest/";
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + "/environmentConfig/";

}
