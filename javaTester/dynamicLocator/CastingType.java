package dynamicLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CastingType {
    public static void main(String[] agrs) {
        // Ngầm định
        byte bNumber = 100;
        System.out.println(bNumber);

        short sNumber = bNumber;
        System.out.println(sNumber);

        int iNumber = sNumber;
        System.out.println(iNumber);

        // Tường minh
        int firstNumber = 1000;
        byte secondNumber = (byte) firstNumber;

        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;

        String siteDomain = (String) jsExcutor.executeAsyncScript("return document.domain;");
    }
}
