package WorkingWithItexsharp.gui;

import WorkingWithItexsharp.model.Student;
import WorkingWithItexsharp.model.StudentTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentTablePanel extends JPanel {

    private JTable studentTable; // JTable pour afficher les données
    private StudentTableModel tableModel; // Modèle pour gérer les données des étudiants

    public StudentTablePanel() {
        // Configuration de base du panneau
        setLayout(new BorderLayout());

        // Initialiser le modèle de table avec une liste vide
        tableModel = new StudentTableModel(List.of());
        studentTable = new JTable(tableModel);

        // Ajouter le JTable à un JScrollPane pour le défilement
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER); // Ajouter le JScrollPane au panneau
    }

    // Méthode pour mettre à jour les données affichées
    public void updateTableData(List<Student> students) {
        tableModel = new StudentTableModel(students);
        studentTable.setModel(tableModel);
    }
}
