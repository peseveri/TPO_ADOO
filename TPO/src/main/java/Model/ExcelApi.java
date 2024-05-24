package Model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


public class ExcelApi {

    public void generarInforme(Docente docente) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Informe Docente");
        Random random = new Random();


        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleStyle.setFont(titleFont);


        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Docente: " + docente.getNombre());
        titleCell.setCellStyle(titleStyle);


        Row headerRow = sheet.createRow(1);
        String[] headers = {"ID Curso", "Aula", "Capacidad","Inscriptos", "Dia", "Horario"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(titleStyle);
        }


        int rowNum = 2;
        for (Curso curso : docente.getCursos()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(curso.getId());
            row.createCell(1).setCellValue(curso.getAula());
            row.createCell(2).setCellValue(curso.getCapacidadAula());
            int randomValue = random.nextInt(10) + 1;
            row.createCell(3).setCellValue(curso.getCapacidadAula() - randomValue);

            String dia = "";
            switch (curso.getDia()) {
                case 1:
                    dia = "Lunes";
                    break;
                case 2:
                    dia = "Martes";
                    break;
                case 3:
                    dia = "Miércoles";
                    break;
                case 4:
                    dia = "Jueves";
                    break;
                case 5:
                    dia = "Viernes";
                    break;
            }
            row.createCell(4).setCellValue(dia);
            row.createCell(5).setCellValue(curso.getHorario());
        }

        // Ajustar el tamaño de las columnas
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream("Informe.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();

        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        System.out.println("Excel guardado en " + directoryName);
    }
}
