package pageFactory.nopCommerce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BagePage {
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }


    private Alert waitToAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitToAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitToAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String valueToSend) {
        waitToAlertPresence(driver).sendKeys(valueToSend);
    }

    public String getTextAlert(WebDriver driver) {
        return waitToAlertPresence(driver).getText();
    }

    private void closeAllWindowWithoutParent(WebDriver driver, String parentID) throws InterruptedException {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String runWindows : allWindowIDs) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                sleepInSecond(LONG_TIMEOUT);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    private void sleepInSecond(long longTimeout) {}

    // HÀM THAO TÁC VỚI ELEMENT/ LIST ELEMENT
    public void clickToElement(WebElement element){
        element.click();
    }

    public void sendkeyToElement(WebElement element, String valueToSend) {
        element.clear();
        element.sendKeys(valueToSend);
    }

    public String getElementText(WebElement element) {
        return  element.getText();
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getDomAttribute(attributeName);
    }

    public WebElement waitForElementVisible(WebDriver driver, WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForListElementVisible(WebDriver driver, List<WebElement> elements){
        return new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForElementClickable(WebDriver driver,WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    private long LONG_TIMEOUT = 30;

}

