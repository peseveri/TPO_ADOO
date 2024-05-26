package Model;

import java.io.IOException;

public class AdapterExcel {
    private ExcelApi excelApi;
    public AdapterExcel( ) {
        this.excelApi = new ExcelApi();
    }
    public Void generarInforme(Docente docente) throws IOException {
        excelApi.generarInforme(docente);
        return  null;
    }
}
