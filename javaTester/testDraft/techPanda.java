package testDraft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class techPanda {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_Tech_Panda() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")
        ));
        accountBtn.click();

        driver.findElement(By.xpath("//div[@id='header-account']/div/ul/li/a[@title='Log In']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
        Thread.sleep(5000);
    }

    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
}








