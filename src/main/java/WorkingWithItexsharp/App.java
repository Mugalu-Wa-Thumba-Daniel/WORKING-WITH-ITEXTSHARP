package WorkingWithItexsharp;

import WorkingWithItexsharp.gui.MainFrame;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        // Lance l'application dans le thread graphique Swing
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
