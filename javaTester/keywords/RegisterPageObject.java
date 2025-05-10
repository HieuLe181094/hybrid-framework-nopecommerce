package keywords;

import org.testng.Assert;

public class RegisterPageObject implements IBrowser{
    String browserName;
    static  String browserVersion;

    // HẰNG SỐ
    static final String ENVIRMENT = "DEV";

    final String fullName = "Automation FC";

    @Override
    public void clickToElement() {
        //fullName = "";

    }

    public static void selectToElement(){

    }

    public String getBrowserName(){
        return browserName;
    }

    public static void main(String[] args){
        RegisterPageObject page = new RegisterPageObject();
        // page: Object/ Instance

        System.out.println(RegisterPageObject.browserVersion);
        System.out.println(page.browserName);

        RegisterPageObject.selectToElement();
        page.clickToElement();

        Assert.assertTrue(page instanceof RegisterPageObject);

    }



}
