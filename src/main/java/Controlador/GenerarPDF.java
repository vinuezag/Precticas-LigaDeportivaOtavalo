/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerarPDF {
    
public void generarPDF(String nombres, String apellidos, int edad, String genero, String deporte, String categoria, String nombresEntrenador) {
    try {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
//ENCABEZADO
        contentStream.beginText();
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
    contentStream.newLineAtOffset(100, 750);
    contentStream.showText("Liga Deportiva Cantonal Otavalo");
    contentStream.endText();
    
    contentStream.beginText();
    contentStream.setFont(PDType1Font.HELVETICA, 12);
    contentStream.newLineAtOffset(100, 730);
    contentStream.showText("Fecha: " + LocalDate.now()); // Puedes personalizar la fecha según tus necesidades
    contentStream.endText();
//CONTENIDO
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Información del Deportista:");
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Nombres: " + nombres);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Apellidos: " + apellidos);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Edad: " + edad);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Género: " + genero);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Deporte: " + deporte);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Categoría: " + categoria);
        contentStream.newLineAtOffset(0, -20); // Ajustar la posición vertical
        contentStream.showText("Nombre del Entrenador: " + nombresEntrenador);
        contentStream.endText();

        
        contentStream.close();

        document.save(nombres + "_" + apellidos + "_InformeDeportista.pdf");

        document.close();

        JOptionPane.showMessageDialog(null, "PDF generado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (IOException e) {
        System.err.println("Error al generar el PDF: " + e.getMessage());
    }
}

    
    
}
