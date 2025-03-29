package WorkingWithItexsharp.database;

import WorkingWithItexsharp.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataLoader {

    // SQL query to retrieve student data
    private static final String QUERY = "SELECT id, name, age, program, email FROM students";

    // Method to load student data from the database
    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            // Iterate through the query results
            while (resultSet.next()) {
                // Create a new Student object for each record
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setProgram(resultSet.getString("program"));
                student.setEmail(resultSet.getString("email"));

                // Add the student to the list
                students.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Error while loading student data: " + e.getMessage());
        }

        return students;
    }
}
