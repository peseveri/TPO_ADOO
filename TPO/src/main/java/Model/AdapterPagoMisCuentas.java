package Model;

public class AdapterPagoMisCuentas {
    PagoMisCuentasApi pagoMisCuentasApi;
    public AdapterPagoMisCuentas() {
        this.pagoMisCuentasApi = new PagoMisCuentasApi();
    }
    public Void abonarCuota(){
        pagoMisCuentasApi.abonarCuota();
        return null;
    }


}
