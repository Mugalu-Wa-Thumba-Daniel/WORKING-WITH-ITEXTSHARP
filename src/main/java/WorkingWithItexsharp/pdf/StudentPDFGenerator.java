package WorkingWithItexsharp.pdf;

import WorkingWithItexsharp.model.Student;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentPDFGenerator {

    // Méthode pour générer le PDF
    public void generatePDF(List<Student> students) {
        // Demander à l'utilisateur de choisir l'emplacement de sauvegarde
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir l'emplacement de sauvegarde");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Ajouter l'extension .pdf si non spécifiée
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try {
                // Initialiser le document PDF
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                // Ajouter un titre au document
                Paragraph title = new Paragraph("Rapport des Étudiants")
                        .setFontSize(20)
                        .setBold()
                        .setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER);
                document.add(title);

                // Ajouter un timestamp
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                Paragraph dateTime = new Paragraph("Date du rapport : " + timestamp)
                        .setFontSize(12)
                        .setTextAlignment(com.itextpdf.layout.property.TextAlignment.RIGHT);
                document.add(dateTime);

                // Ajouter un espace avant le tableau
                document.add(new Paragraph("\n"));

                // Créer un tableau pour afficher les données des étudiants
                Table table = new Table(new float[]{1, 3, 2, 3, 4}); // Largeur des colonnes
                table.setWidthPercent(100);

                // Ajouter les en-têtes au tableau
                table.addHeaderCell(new Cell().add(new Paragraph("ID").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Nom").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Âge").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Programme").setBold()));
                table.addHeaderCell(new Cell().add(new Paragraph("Email").setBold()));

                // Ajouter les données des étudiants au tableau
                for (Student student : students) {
                    table.addCell(String.valueOf(student.getId()));
                    table.addCell(student.getName());
                    table.addCell(String.valueOf(student.getAge()));
                    table.addCell(student.getProgram());
                    table.addCell(student.getEmail());
                }

                // Ajouter le tableau au document
                document.add(table);

                // Fermer le document
                document.close();

                // Confirmation de la réussite
                JOptionPane.showMessageDialog(null, "PDF généré avec succès à l'emplacement : " + filePath);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la génération du PDF : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
