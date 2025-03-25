package WorkingWithItexsharp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {

    private JButton loadDataButton;     // Bouton pour charger les données
    private JButton exportToPDFButton; // Bouton pour exporter en PDF

    public ActionPanel(ActionListener loadDataListener, ActionListener exportPDFListener) {
        // Configuration du layout
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Initialisation des boutons
        loadDataButton = new JButton("Charger les Données");
        exportToPDFButton = new JButton("Exporter en PDF");

        // Ajout des gestionnaires d'événements
        loadDataButton.addActionListener(loadDataListener);
        exportToPDFButton.addActionListener(exportPDFListener);

        // Ajouter les boutons au panneau
        add(loadDataButton);
        add(exportToPDFButton);
    }
}
