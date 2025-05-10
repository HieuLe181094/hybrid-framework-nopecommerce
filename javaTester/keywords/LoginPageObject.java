package keywords;

public class LoginPageObject extends BasePage {
    // Global Variable
    String browserName;

    public LoginPageObject() {
        // Gọi qua constructor của lớp Cha (BasePage)
        // super(browserName);

        //..
    }

    @Override
    public boolean isPageDisplayed() {
        // Local Variable
        String browserName = "Chrome";

        System.out.println(browserName);

        // Block Code
        if (browserName.equals("Chrome")){
            // Local Variable
            String fullName = "";

        }

        System.out.println(this.browserName);

        return false;
    }

}
