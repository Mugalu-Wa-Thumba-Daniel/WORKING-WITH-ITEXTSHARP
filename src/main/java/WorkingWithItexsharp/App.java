package WorkingWithItexsharp;

import WorkingWithItexsharp.gui.MainFrame;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        // Launch the application in the Swing graphic thread
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
