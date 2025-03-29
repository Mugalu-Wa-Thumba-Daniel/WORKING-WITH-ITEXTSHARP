package WorkingWithItexsharp.database;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    // Méthode pour tester la connexion
    public static boolean test() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            return connection != null && !connection.isClosed(); // Vérifie que la connexion est active
        } catch (SQLException e) {
            System.err.println("Connection test failed: " + e.getMessage());
            return false;
        }
    }
}
