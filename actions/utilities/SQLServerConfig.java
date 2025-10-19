package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConfig {

    public static Connection getSQLServerConnection() {
        String hostName = "localhost";          // hoặc "127.0.0.1"
        String database = "nopcommerce";
        String userName = "sa";
        String password = "Automation111!!!";   // đúng với docker-compose.yml

        return getSQLServerConnection(hostName, database, userName, password);
    }

    private static Connection getSQLServerConnection(String hostName, String database, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cấu trúc URL Connection dành cho SQL Server (dùng SQL trên DOCKER)
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;" +
                    "databaseName=" + database + ";" +
                    "encrypt=false;trustServerCertificate=true;";

            conn = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("✅ Connected to SQL Server successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
