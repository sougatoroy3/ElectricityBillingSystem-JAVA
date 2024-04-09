package electricity.billing.system;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
*
* @author souga
*/

public class Conn {
    Connection c;
    Statement s;

    Conn() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Load properties file
            Properties prop = new Properties();
            prop.load(input);

            // Get database credentials from properties file
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            // Create connection
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
