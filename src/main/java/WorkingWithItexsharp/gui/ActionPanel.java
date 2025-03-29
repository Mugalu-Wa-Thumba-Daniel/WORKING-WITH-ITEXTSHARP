package WorkingWithItexsharp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {

    private JButton loadDataButton;     // Button to load data
    private JButton exportToPDFButton; // Button to export to PDF

    public ActionPanel(ActionListener loadDataListener, ActionListener exportPDFListener) {
        // Layout configuration
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Button initialization
        loadDataButton = new JButton("Load Data");
        exportToPDFButton = new JButton("Export to PDF");

        // Add event listeners
        loadDataButton.addActionListener(loadDataListener);
        exportToPDFButton.addActionListener(exportPDFListener);

        // Add buttons to the panel
        add(loadDataButton);
        add(exportToPDFButton);
    }
}
