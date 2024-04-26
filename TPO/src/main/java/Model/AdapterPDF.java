package Model;

import java.io.IOException;

/**
 * 
 */
public class AdapterPDF {

    private PdfApi apiPDF;

    public AdapterPDF() {
    }

    public Void generarInforme(Docente docente) throws IOException {
        PdfApi apiPDF = new PdfApi();
        apiPDF.generarInforme(docente);
        return null;
    }

}