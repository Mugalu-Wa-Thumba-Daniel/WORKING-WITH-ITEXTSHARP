package WorkingWithItexsharp.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    // Colonnes du tableau
    private final String[] columnNames = {"ID", "Nom", "Âge", "Programme", "Email"};

    // Liste des étudiants
    private final List<Student> students;

    // Constructeur pour initialiser le modèle avec une liste d'étudiants
    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size(); // Nombre de lignes (nombre d'étudiants)
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Nombre de colonnes
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex]; // Nom des colonnes
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtenez l'étudiant à l'index spécifié
        Student student = students.get(rowIndex);

        // Retournez la valeur de l'attribut correspondant à la colonne spécifiée
        switch (columnIndex) {
            case 0:
                return student.getId(); // ID
            case 1:
                return student.getName(); // Nom
            case 2:
                return student.getAge(); // Âge
            case 3:
                return student.getProgram(); // Programme
            case 4:
                return student.getEmail(); // Email
            default:
                return null; // Par défaut
        }
    }

    // Permet d'ajouter un étudiant à la liste et de rafraîchir le tableau
    public void addStudent(Student student) {
        students.add(student);
        fireTableRowsInserted(students.size() - 1, students.size() - 1); // Notification de mise à jour
    }

    // Permet de supprimer un étudiant à un index donné
    public void removeStudent(int rowIndex) {
        students.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex); // Notification de suppression
    }
}
