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
    public static final String DEV_URL = "https://demo.nopcommerce.com/";
    public static final String LOCAL_DEV_URL = "http://localhost:8086/";
    public static final String TEST_URL = "http://test.localhost/";
    public static final String LIVE_URL = "http://live.localhost/";

    // OS Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // Admin User/ Pass - NOPCOMMERCE
    public static final String NOP_ADMIN_USERNAME = "hieule1810@gmail.com";
    public static final String NOP_ADMIN_PASSWORD = "Automation111!!!";

    // Upload/ Download
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Browser Logs/ Extension
    public  static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public  static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "testData" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "envConfig" + SEPARATOR;

    public static final String JIRA_SITE_URL = "https://lengoduchieu-auto.atlassian.net/";
    public static final String JIRA_USERNAME = "lengoduchieu@gmail.com";
    public static final String ATLASSIAN_API_TOKEN = System.getenv("ATLASSIAN_API_TOKEN");
    public static final String JIRA_PROJECT_KEY ="SCRUM";

    // Admin User/ Pass - ORANGEHRM
    public static final String ADMIN_USERNAME_ORANGEHRM = "HieuLND";
    public static final String ADMIN_PASSWORD_ORANGEHRM = "99*10bsFiOXrmERLTO";

    // BrowserStack
    public static final String BROWSER_STACK_USERNAME = "hieulnd_XN5nSG";
    public static final String BROWSER_STACK_AUTOMATE_KEY = "TuaaWsixjYgzRypkrKBA";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_STACK_USERNAME + ":" + BROWSER_STACK_AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

    // SauceLab
    public static final String SAUCE_USERNAME = "oauth-lengoduchieu-ce5e9";
    public static final String SAUCE_AUTOMATE_KEY = "5338bfe7-c0c0-4e54-805a-347496c9be03";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    // Bitbar
    public static final String BITBAR_AUTOMATE_KEY = "XMUHh2sjQJVUYwn5KsklfpTdueTQAEUD";
    public static final String BITBAR_EU_URL = "https://eu-desktop-hub.bitbar.com/wd/hub";
    public static final String BITBAR_US_URL = "https://us-west-desktop-hub.bitbar.com/wd/hub";

    // LambaTest
    public static final String LAMBDA_USERNAME = "lengoduchieu";
    public static final String LAMBDA_AUTOMATE_KEY = "LT_Ckf5aFrFrI5uvTfcoNdyYnGiYu82RBO8kCCnd5eFxYGiLdp";
    public static final String LAMBDA_URL = "https://hub.lambdatest.com/wd/hub";



}
