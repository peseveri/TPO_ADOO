package Model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PdfApi {


    public Void generarInforme(Docente docente) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        Random random = new Random();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA, 12);

        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);
        contentStream.setLeading(14.5f);
        contentStream.showText("Docente: " + docente.getNombre());
        contentStream.newLine();


        for (int i = 0; i < docente.getCursos().size(); i++) {
            Curso curso = docente.getCursos().get(i);
            String dia = "";
            int diaSemana = curso.getDia();
            switch (diaSemana) {
                case 1:
                    dia = "Lunes";
                    break;
                case 2:
                    dia = "Martes";
                    break;
                case 3:
                    dia = "Miercoles";
                    break;
                case 4:
                    dia = "Jueves";
                    break;
                case 5:
                    dia = "Viernes";
                    break;
            }

            int randomValue = random.nextInt(10) + 1;
            String mensaje = String.format("ID Curso: %d, Aula: %s , Capacidad: %s, Inscriptos: %s, Dia: %s , Horario: %s ", curso.getId(), curso.getAula(), curso.getCapacidadAula(),curso.getCapacidadAula() - randomValue,dia, curso.getHorario());
            contentStream.showText(mensaje);
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();
        document.save("Informe.pdf");
        document.close();
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        System.out.println("PDF guardado en " + directoryName);
        return null;
    }

}