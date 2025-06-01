package dynamicLocator;

import java.io.File;

public class SystemInformation {
    public static void main (String[] agrs) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);

        String projectPath = System.getProperty("user.dir");

        String separator = System.getProperty("file.separator");
        System.out.println(separator);


        String bodyImagePath = projectPath + File.separator + "uploadFiles" + File.separator + "Body.jpg" + "\n";
        System.out.println(bodyImagePath);
        System.out.println(bodyImagePath.trim());

        // D:\Automation Testing\03-Java Hybrid Framework\hybrid-framework-nopecommerce
    }
}
