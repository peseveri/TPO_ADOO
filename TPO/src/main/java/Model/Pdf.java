package Model;

import java.io.IOException;

public class Pdf implements  EstrategiaInforme{

    private AdapterPDF adapterPDF;

    public Pdf() {
        this.adapterPDF = new AdapterPDF();
    }

    @Override
    public void generarInforme(Docente docente) throws IOException {
        adapterPDF.generarInforme(docente);
    }
}
