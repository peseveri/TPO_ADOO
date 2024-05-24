package Model;

import java.io.IOException;

/**
 * 
 */
public class AdapterPDF {

    private PdfApi apiPDF;

    public AdapterPDF( ) {
        this.apiPDF = new PdfApi() ;
    }
    public Void generarInforme(Docente docente) throws IOException {
        apiPDF.generarInforme(docente);
        return null;
    }

}