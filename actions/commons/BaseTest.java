package commons;
import browserFactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;


public class BaseTest {
    public WebDriver getDriver() {
        return driver;
    }

    WebDriver driver;
    protected final Logger log;
    String projectFolder = System.getProperty("user.dir");
    public Platform platform;

    public BaseTest() {
        log = LogManager.getLogger(getClass());

    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    // LOCAL
    protected WebDriver getBrowserDriver(String browserName){
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        switch (browserType){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(GlobalConstants.DEV_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

    // LOCAL
    protected WebDriver getBrowserDriver(String url, String browserName) {
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());

        switch (browserType){
            case FIREFOX:
                driver = new FirefoxBrowserManager().getDriver();
                break;
            case HFIREFOX:
                driver = new FirefoxHeadlessBrowserManager().getDriver();
                break;

            case CHROME:
                driver = new ChromeBrowserManager().getDriver();
                break;
            case HCHROME:
                driver = new ChromeHeadlessBrowserManager().getDriver();
                break;

            case COCCOC:
                driver = new CocCocBrowserManager().getDriver();
                break;

            case IE:
                driver = new IEBrowserManager().getDriver();
                break;

            case SAFARI:
                driver = new SafariBrowserManager().getDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    // GRID: VIRTUAL/ REAL MACHINE
    protected WebDriver getBrowserDriver(String browserName, String url, String osName, String ipAddress, String portNumber) {
        Capabilities capability = null;

        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://192.168.0.163:4444", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    // Cloud: BrowserStack
    protected WebDriver getBrowserDriverBrowserStack(String url, String osName, String osVersion, String browserName, String browserVersion) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();

        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
        bstackOptions.put("userName", GlobalConstants.BROWSER_STACK_USERNAME);
        bstackOptions.put("accessKey", GlobalConstants.BROWSER_STACK_AUTOMATE_KEY);
        bstackOptions.put("seleniumVersion", "4.31.0");
        bstackOptions.put("buildName", "NopCommerce");
        bstackOptions.put("sessionName", "Automation");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    // Cloud: SauceLab
    protected WebDriver getBrowserDriverSauceLab(String url, String platformName, String browserName, String browserVersion) {
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platformName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platformName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platformName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platformName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put("username", GlobalConstants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "automation-fc-build");
        sauceOptions.put("name", "Run on " + platformName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    // Cloud: Bitbar
    protected WebDriver getBrowserDriverBitbar(String url, String platformName, String platformVersion, String browserName, String browserVersion) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bitbarOptions = new HashMap<String, String>();

        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        bitbarOptions.put("project", "NopCommerce");
        bitbarOptions.put("testrun", "Run on " + browserName.toUpperCase() + " - " + platformName + " - " + platformVersion);
        bitbarOptions.put("apiKey", GlobalConstants.BITBAR_AUTOMATE_KEY);
        bitbarOptions.put("osVersion", platformVersion);

        if (platformName.contains("Windows") || platformName.contains("Linux")) {
            bitbarOptions.put("resolution", "1920x1080");
        } else {
            bitbarOptions.put("resolution", "1920x1200");
        }

        bitbarOptions.put("seleniumVersion", "4");

        capabilities.setCapability("bitbar:options", bitbarOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BITBAR_US_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    // Cloud: LambdaTest
    protected WebDriver getBrowserDriverLambda(String url, String osName, String browserName, String browserVersion) {
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(osName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(osName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(osName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(osName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        HashMap<String, Object> lambdaOptions = new HashMap<String, Object>();
        lambdaOptions.put("username", GlobalConstants.LAMBDA_USERNAME);
        lambdaOptions.put("accessKey", GlobalConstants.LAMBDA_AUTOMATE_KEY);
        lambdaOptions.put("visual", true);
        lambdaOptions.put("video", true);
        lambdaOptions.put("build", "nopcommerce-build");
        lambdaOptions.put("project", "NopCommerce - UI Automation Testing");
        lambdaOptions.put("name", "Run on " + osName + " | " + browserName + " | " + browserVersion + " | " + formater.format(calendar.getTime()));
        lambdaOptions.put("w3c", true);
        lambdaOptions.put("selenium_version", "4.33.0");
        lambdaOptions.put("resolution", "1920x1080");
        lambdaOptions.put("plugin", "java-testNG");

        capability.setCapability("LT:Options", lambdaOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    private String getUrlByEnvironment(String environmentName){
        String url;
        switch (environmentName) {
            case "dev":
                url = "https://demo.nopcommerce.com/";
                break;
            case "testing":
                url = "https://testing.nopcommerce.com/";
                break;
            case "staging":
                url = "https://staging.nopcommerce.com/";
                break;
            default:
                throw new RuntimeException("Environment name is not valid");
        }
        return url;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void assertTrue(boolean condition){
        Assert.assertTrue(verifyTrue(condition));
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------FAILED-----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------FAILED-----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------FAILED-----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
        deleteAllFileInFolder("allure-results");

    }


    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
