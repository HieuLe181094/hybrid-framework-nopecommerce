package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.io.IOException;

public class UserLevelData {

    public static UserLevelData getUser() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "UserLevel.json"), UserLevelData.class);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("Register")
    Register register;

    // Inner Class
    static class Register {
        @JsonProperty("fullname")
        private  String fullname;
    }

    @JsonProperty("Login")
    Login login;
    static class Login{
        @JsonProperty("user")
        private String user;

        @JsonProperty("password")
        private String password;
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return register.fullname;
    }

    public String getUsername(){
        return login.user;
    }

    public String getPassword(){
        return login.password;
    }
}
