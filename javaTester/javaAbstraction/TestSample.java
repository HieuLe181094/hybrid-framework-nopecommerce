package javaAbstraction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class TestSample {

    public static void main(String[] args) {
//        Animals animals = new Animals();

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("");
        firefoxDriver.getTitle();

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("");
        chromeDriver.getTitle();
    }

}
