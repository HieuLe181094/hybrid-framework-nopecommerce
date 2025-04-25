package com.nopecommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

public class Leve_01_Register {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

    }

    @Test
    public void Register_01(){

    }

    @Test
    public void Register_02(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
