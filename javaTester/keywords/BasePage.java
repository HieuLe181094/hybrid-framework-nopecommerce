package keywords;

public abstract class BasePage {

    public BasePage(){

    }

    public BasePage(String browserName){

    }

    // Dùng để thể hiện tính chất trừu tượng (abstraction) của OOP

    // Abstract Method
    public abstract boolean isPageDisplayed();

    // Non - Abstract Method
    public void clickToElement(){

    }

    // private/ default/ protected/ public

    // Thuộc tính - Properties/ Field/ Variable
    private String fullName;
    String city;
    protected  String address;
    public String phoneNumber;

    // Hàm/ Phương thức - Method/ Function
    private  void setFullName(){

    }

    void setCity() throws InterruptedException {
        Thread.sleep(3000);

    }

    protected void setAddress(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void setPhoneNumber(){

    }

    public boolean isElementDisplayed(){

        try {
            // Action - Happe case
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            //
        }

        return false;
    }

}
