package WorkingWithItexsharp.gui;

import WorkingWithItexsharp.model.Student;
import WorkingWithItexsharp.model.StudentTableModel;
import WorkingWithItexsharp.database.StudentDataLoader;
import WorkingWithItexsharp.database.TestConnection; // Import the new TestConnection class
import WorkingWithItexsharp.pdf.StudentPDFGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Collections;

public class MainFrame extends JFrame {

    private JTable studentTable; // Table to display students
    private StudentTableModel tableModel; // Model to manage student data
    private JButton loadDataButton; // Button to load data from the database
    private JButton exportToPDFButton; // Button to export data to PDF
    private JButton testConnectionButton; // Button to test the database connection

    public MainFrame() {
        // Basic window configuration
        setTitle("Student Management - University");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Initialize components
        initComponents();

        // Add components to the window
        layoutComponents();
    }

    private void initComponents() {
        // Initialize the model with an empty list of students
        tableModel = new StudentTableModel(Collections.emptyList());

        // Initialize the table with the model
        studentTable = new JTable(tableModel);

        // Initialize the buttons
        loadDataButton = new JButton("Load Data");
        exportToPDFButton = new JButton("Export to PDF");
        testConnectionButton = new JButton("Test Connection"); // New button to test connection

        // Add event listeners to the buttons
        loadDataButton.addActionListener(e -> loadData());
        exportToPDFButton.addActionListener(e -> exportToPDF());
        testConnectionButton.addActionListener(e -> testConnection()); // Add the test connection action
    }

    private void layoutComponents() {
        // Create a main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add the table to a panel with a scroll bar
        mainPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(testConnectionButton); // Add the Test Connection button
        buttonPanel.add(loadDataButton);
        buttonPanel.add(exportToPDFButton);

        // Add the button panel to the bottom of the window
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the window
        add(mainPanel);
    }

    private void loadData() {
        // Load data from the database
        StudentDataLoader dataLoader = new StudentDataLoader();
        List<Student> students = dataLoader.loadStudents();

        // Update the table model
        tableModel = new StudentTableModel(students);
        studentTable.setModel(tableModel);

        JOptionPane.showMessageDialog(this, "Data loaded successfully!");
    }

    private void exportToPDF() {
        // Check if the table contains data
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No data to export!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Retrieve data from the table model
        List<Student> students = tableModel.getStudents(); // Access the list of students

        // Create an instance of StudentPDFGenerator
        StudentPDFGenerator pdfGenerator = new StudentPDFGenerator();

        // Call the generatePDF method with the list of students
        pdfGenerator.generatePDF(students);
    }

    private void testConnection() {
        // Test the database connection and display a message
        boolean isConnected = TestConnection.test();
        if (isConnected) {
            JOptionPane.showMessageDialog(this, "Connection successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and display the main window
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
