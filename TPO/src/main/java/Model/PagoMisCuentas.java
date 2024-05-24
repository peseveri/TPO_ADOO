package Model;

public class PagoMisCuentas implements EstrategiaPago{

    AdapterPagoMisCuentas adapterPagoMisCuentas;

    public PagoMisCuentas() {
        this.adapterPagoMisCuentas = new AdapterPagoMisCuentas();
    }
    @Override
    public void abonarCuota() {
        adapterPagoMisCuentas.abonarCuota();
    }
}
