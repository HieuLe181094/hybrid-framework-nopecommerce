package data.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    @JsonProperty("employees")
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public static EmployeeList getEmployeeList() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "EmployeesList.json"), EmployeeList.class);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static class Employee{
        public String name;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("age")
        private int ageNumber;

        public String getName() {
            return name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public int getAgeNumber() {
            return ageNumber;
        }
    }

}
