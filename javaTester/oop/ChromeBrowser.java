package oop;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ChromeBrowser extends Browser implements IBrowser {
    ChromeDriver chromeDriver;
    CommandExecutor commandExecutor;
    Capabilities capabilities;
    String capabilityKey;
    WebDriver driver;

    //ChromeDriver chromeDriver = new ChromeDriver();

    public void endUser(){
        openUrl();
        back();
        forward();
        refresh();
    }

    @Override
    public void openUrl() {
        findElement(By.cssSelector(""));

    }

    @Override
    public void back() {
        findElement(By.cssSelector(""));

        chromeDriver.getCastSinks();

    }

    @Override
    public void forward() {
        findElement(By.cssSelector(""));

    }

    @Override
    public void refresh() {
        findElement(By.cssSelector(""));

    }

    public WebElement findElement(By by){
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
}
