package getSetter;

import java.util.regex.Pattern;

public class User {
    // Thuộc tính
    private String firstName  = "Essie";
    private String lastName = "Geard";
    private String emailAddress = "egeard4@craigslist.org";

    //Phương thức
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        if (emailAddress != null && p.matcher(emailAddress).matches()){
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Email is not valid!");
        }
    }

}
