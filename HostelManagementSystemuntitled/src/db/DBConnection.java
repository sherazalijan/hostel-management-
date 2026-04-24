package db; // Must be exactly 'db'

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        try {
            // Replace with your actual database details
            String url = "jdbc:mysql://localhost:3306/hostel_management";
            String user = "root";
            String password = "Pakistan135";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}