package javaAbstraction;

public interface IWebDriver {
    // Thuộc tính là HẰNG SỐ
    String name = "Automation Testing";

    public static final String ADDRESS = "";

    // Ko có những Non-Abstract

    // 100% đều là Abstract Method
    void eat();

    public void sleep();

    public abstract void run();

    public default void clickToElement(){

    }
}
