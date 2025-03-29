package WorkingWithItexsharp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database connection URL (e.g., MySQL)
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/university";
    private static final String DATABASE_USER = "root"; // Database username
    private static final String DATABASE_PASSWORD = "########"; // Database password

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver (optional with modern Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("The JDBC driver was not found. Make sure it is in the classpath.", e);
        }
    }
}
