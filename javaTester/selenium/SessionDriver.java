package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class SessionDriver {
    public static void main(String[] agrs){
//        WebDriver driver = new FirefoxDriver();
//        SessionId sessionID = ((RemoteWebDriver) driver).getSessionId();
//        System.out.println("SessionID = " + sessionID);
//        System.out.println("Driver ID =" + driver.toString());

        System.out.println(System.getProperty("java.version"));
    }
}
