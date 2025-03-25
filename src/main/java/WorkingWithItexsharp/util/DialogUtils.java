package WorkingWithItexsharp.util;

import javax.swing.*;

public class DialogUtils {

    // Méthode pour afficher un message d'information
    public static void showInfoDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Méthode pour afficher un message d'erreur
    public static void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Méthode pour afficher un message d'avertissement
    public static void showWarningDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    // Méthode pour demander une confirmation à l'utilisateur
    public static boolean showConfirmDialog(String title, String message) {
        int response = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return response == JOptionPane.YES_OPTION;
    }
}
