package WorkingWithItexsharp.gui;

import WorkingWithItexsharp.model.Student;
import WorkingWithItexsharp.model.StudentTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import java.util.Collections;

public class StudentTablePanel extends JPanel {

    private JTable studentTable; // JTable to display data
    private StudentTableModel tableModel; // Model to manage student data

    public StudentTablePanel() {
        // Basic panel configuration
        setLayout(new BorderLayout());

        // Initialize the table model with an empty list
        tableModel = new StudentTableModel(Collections.emptyList());
        studentTable = new JTable(tableModel);

        // Add the JTable to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER); // Add the JScrollPane to the panel
    }

    // Method to update displayed data
    public void updateTableData(List<Student> students) {
        tableModel = new StudentTableModel(students);
        studentTable.setModel(tableModel);
    }
}
