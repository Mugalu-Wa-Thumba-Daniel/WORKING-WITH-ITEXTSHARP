package WorkingWithItexsharp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de connexion à la base de données (par exemple : MySQL)
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/university";
    private static final String DATABASE_USER = "root"; // Nom d'utilisateur de la base de données
    private static final String DATABASE_PASSWORD = "@Danne2024"; // Mot de passe de la base de données

    // Méthode pour établir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        try {
            // Charger le pilote JDBC (optionnel avec les versions modernes de Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Le pilote JDBC n'a pas été trouvé. Assurez-vous qu'il est dans le classpath.", e);
        }
    }
}
