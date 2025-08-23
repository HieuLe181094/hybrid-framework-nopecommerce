package data;

import commons.GlobalConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserProperties {
    public static void main(String [] agrs){
        try (InputStream input = new FileInputStream(GlobalConstants.DATA_TEST_PATH + "user.properties")){
            Properties prop = new Properties();

            // load a properties file;
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("firstname"));
            System.out.println(prop.getProperty("lastname"));
            System.out.println(prop.getProperty("company"));
            System.out.println(prop.getProperty("email"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException  e){
            throw new RuntimeException(e);
        }
    }
}
