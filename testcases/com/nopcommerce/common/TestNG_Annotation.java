package com.nopcommerce.common;

import org.testng.annotations.*;

public class TestNG_Annotation {
    @BeforeTest
    public void beforeTest(){
        System.out.println("Run before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Run after Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Run before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Run after Class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Run after Method");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Run before Method");
    }

    @Test
    public void TC_01(){
        System.out.println("TC01");
    }

    @Test
    public void TC_02(){
        System.out.println("TC02");
    }
}
