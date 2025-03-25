package WorkingWithItexsharp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    // Format par défaut pour les dates
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Méthode pour obtenir la date et l'heure actuelles formatées
    public static String getCurrentTimestamp() {
        // Obtenir la date et l'heure actuelles
        LocalDateTime now = LocalDateTime.now();

        // Formater la date et l'heure
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return now.format(formatter);
    }

    // Méthode pour formater une date selon un format personnalisé
    public static String formatDateTime(LocalDateTime dateTime, String format) {
        if (dateTime == null || format == null || format.isEmpty()) {
            throw new IllegalArgumentException("La date ou le format ne peut pas être null ou vide.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
