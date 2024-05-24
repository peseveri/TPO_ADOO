package Model;

public class MercadoPago implements EstrategiaPago{

    private AdapterMercadoPago adapterMercadoPago;

    public MercadoPago() {
        this.adapterMercadoPago = new AdapterMercadoPago();
    }

    @Override
    public void abonarCuota() {
        adapterMercadoPago.abonarCuota();
    }
}
