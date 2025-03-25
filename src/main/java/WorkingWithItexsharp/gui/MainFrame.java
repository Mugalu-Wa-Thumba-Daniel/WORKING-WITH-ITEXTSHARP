package WorkingWithItexsharp.gui;

import WorkingWithItexsharp.model.Student;
import WorkingWithItexsharp.model.StudentTableModel;
import WorkingWithItexsharp.database.StudentDataLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private JTable studentTable; // Tableau pour afficher les étudiants
    private StudentTableModel tableModel; // Modèle pour gérer les données des étudiants
    private JButton loadDataButton; // Bouton pour charger les données depuis la base de données
    private JButton exportToPDFButton; // Bouton pour exporter les données en PDF

    public MainFrame() {
        // Configuration de base de la fenêtre
        setTitle("Gestion des Étudiants - Université");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

        // Initialisation des composants
        initComponents();

        // Ajout des composants à la fenêtre
        layoutComponents();
    }

    private void initComponents() {
        // Initialiser le modèle avec une liste vide d'étudiants
        tableModel = new StudentTableModel(List.of());

        // Initialiser le tableau avec le modèle
        studentTable = new JTable(tableModel);

        // Initialiser les boutons
        loadDataButton = new JButton("Charger les Données");
        exportToPDFButton = new JButton("Exporter en PDF");

        // Ajouter des gestionnaires d'événements aux boutons
        loadDataButton.addActionListener(e -> loadData());
        exportToPDFButton.addActionListener(e -> exportToPDF());
    }

    private void layoutComponents() {
        // Créer un panneau principal avec un layout BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Ajouter le tableau dans un panneau avec une barre de défilement
        mainPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Créer un panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadDataButton);
        buttonPanel.add(exportToPDFButton);

        // Ajouter le panneau des boutons en bas de la fenêtre
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
    }

    private void loadData() {
        // Charger les données depuis la base de données
        StudentDataLoader dataLoader = new StudentDataLoader();
        List<Student> students = dataLoader.loadStudents();

        // Mettre à jour le modèle de table
        tableModel = new StudentTableModel(students);
        studentTable.setModel(tableModel);

        JOptionPane.showMessageDialog(this, "Les données ont été chargées avec succès !");
    }

    private void exportToPDF() {
        // Vérifiez si le tableau contient des données
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Aucune donnée à exporter !", "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Récupérez les données du modèle de table
        List<Student> students = tableModel.students; // Accédez à la liste des étudiants

        // Créez une instance de StudentPDFGenerator
        StudentPDFGenerator pdfGenerator = new StudentPDFGenerator();

        // Appelez la méthode generatePDF avec la liste des étudiants
        pdfGenerator.generatePDF(students);
    }


    public static void main(String[] args) {
        // Créer et afficher la fenêtre principale
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
