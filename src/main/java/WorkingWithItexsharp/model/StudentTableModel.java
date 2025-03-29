package WorkingWithItexsharp.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    // Table columns
    private final String[] columnNames = {"ID", "Name", "Age", "Program", "Email"};

    // List of students
    private final List<Student> students;

    // Constructor to initialize the model with a list of students
    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public int getRowCount() {
        return students.size(); // Number of rows (number of students)
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Number of columns
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex]; // Column names
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Get the student at the specified index
        Student student = students.get(rowIndex);

        // Return the value of the attribute corresponding to the specified column
        switch (columnIndex) {
            case 0:
                return student.getId(); // ID
            case 1:
                return student.getName(); // Name
            case 2:
                return student.getAge(); // Age
            case 3:
                return student.getProgram(); // Program
            case 4:
                return student.getEmail(); // Email
            default:
                return null; // Default
        }
    }

    // Add a student to the list and refresh the table
    public void addStudent(Student student) {
        students.add(student);
        fireTableRowsInserted(students.size() - 1, students.size() - 1); // Update notification
    }

    // Remove a student at a given index
    public void removeStudent(int rowIndex) {
        students.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // Deletion notification
    }
}
