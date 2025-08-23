package data.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("skilltree")
    private List<String> skilltree;

    @JsonProperty("address")
    private Address address;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public List<String> getSkilltree() {
        return skilltree;
    }

    public Address getAddress() {
        return address;
    }

    public static EmployeeData getEmployee() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "Employee.json"), EmployeeData.class);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static class Address{
        @JsonProperty("street")
        private String streetName;

        @JsonProperty("streetNo")
        private String streetNumber;

        public String getStreetName() {
            return streetName;
        }

        public String getStreetNumber() {
            return streetNumber;
        }
    }


}
