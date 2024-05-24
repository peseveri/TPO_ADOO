package Model;

import java.io.IOException;

public class Excel implements  EstrategiaInforme{

    private AdapterExcel adapterExcel;

    public Excel() {
        this.adapterExcel = new AdapterExcel();
    }

    @Override
    public void generarInforme(Docente docente) throws IOException {
       adapterExcel.generarInforme(docente);
    }
}
