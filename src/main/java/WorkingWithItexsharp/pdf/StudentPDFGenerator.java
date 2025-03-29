package WorkingWithItexsharp.pdf;

import WorkingWithItexsharp.model.Student;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.HorizontalAlignment;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentPDFGenerator {

    // Method to generate the PDF
    public void generatePDF(List<Student> students) {
        // Prompt the user to choose the save location
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose save location");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Add .pdf extension if not specified
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try {
                // Initialize the PDF document
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                // Add a title to the document
                Paragraph title = new Paragraph("Student Report")
                        .setFontSize(20)
                        .setBold()
                        .setHorizontalAlignment(HorizontalAlignment.CENTER);
                document.add(title);

                // Add a timestamp
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                Paragraph dateTime = new Paragraph("Report Date: " + timestamp)
                        .setFontSize(12)
                        .setHorizontalAlignment(HorizontalAlignment.RIGHT);
                document.add(dateTime);

                // Add space before the table
                document.add(new Paragraph("\n"));

                // Create a table to display student data
                Table table = new Table(new float[]{1, 3, 2, 3, 4}); // Column widths
                table.setWidth(UnitValue.createPercentValue(100)); // Set table width

                // Add headers to the table
                table.addHeaderCell(new Cell().add(new Paragraph("ID").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Name").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Age").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Program").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Email").setBold()));

                // Add student data to the table
                for (Student student : students) {
                    table.addCell(String.valueOf(student.getId()));
                    table.addCell(student.getName());
                    table.addCell(String.valueOf(student.getAge()));
                    table.addCell(student.getProgram());
                    table.addCell(student.getEmail());
                }

                // Add the table to the document
                document.add(table);

                // Close the document
                document.close();

                // Success confirmation
                JOptionPane.showMessageDialog(null, "PDF successfully generated at: " + filePath);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error while generating the PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
