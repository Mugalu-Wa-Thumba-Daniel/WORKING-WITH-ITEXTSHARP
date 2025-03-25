package WorkingWithItexsharp.database;

import WorkingWithItexsharp.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataLoader {

    // Requête SQL pour récupérer les données des étudiants
    private static final String QUERY = "SELECT id, name, age, program, email FROM students";

    // Méthode pour charger les données des étudiants depuis la base de données
    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            // Itération sur les résultats de la requête
            while (resultSet.next()) {
                // Créer un nouvel objet Student pour chaque enregistrement
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setProgram(resultSet.getString("program"));
                student.setEmail(resultSet.getString("email"));

                // Ajouter l'étudiant à la liste
                students.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des données des étudiants : " + e.getMessage());
        }

        return students;
    }
}
