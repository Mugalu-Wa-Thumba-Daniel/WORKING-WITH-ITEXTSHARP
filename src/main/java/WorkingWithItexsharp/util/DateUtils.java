package WorkingWithItexsharp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    // Default date format
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Method to get the current formatted date and time
    public static String getCurrentTimestamp() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return now.format(formatter);
    }

    // Method to format a date using a custom format
    public static String formatDateTime(LocalDateTime dateTime, String format) {
        if (dateTime == null || format == null || format.isEmpty()) {
            throw new IllegalArgumentException("Date or format cannot be null or empty.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
