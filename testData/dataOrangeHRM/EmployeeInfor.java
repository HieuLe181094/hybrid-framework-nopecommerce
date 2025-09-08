package dataOrangeHRM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInfor {
    private String firstName;
    private String lastName;

    private String editFirstName;
    private String editLastName;
    private String driverLicenseNumber;
    private String driverLicenseExpiryDate;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String gender;

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String telephoneNumberOfHome;
    private String telephoneNumberOfWork;
    private String telephoneNumberOfMobile;
    private String workEmail;
    private String otherEmail;


    private String nameEmergency;
    private String relationship;
    private String telephoneNumberOfHomeEmergency;
    private String telephoneNumberOfMobileEmergency;
    private String telephoneNumberOfWorkEmergency;

    private String emailAddress;
    private String companyName;
    private String password;

    public static EmployeeInfor getUserData(){
        return new EmployeeInfor();
    }


}
