package oop;

public class FirefoxBrowser extends Browser{

    public void endUser(){
        openUrl();
        forward();
        back();
        System.out.println(browserName);
    }
}
