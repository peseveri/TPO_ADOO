package Model;

/**
 * 
 */
public class AdapterMercadoPago {

    private MercadoPagoAPI apiMP;

    public AdapterMercadoPago() {
        this.apiMP = new MercadoPagoAPI();
    }

    public Void abonarCuota() {
        MercadoPagoAPI apiMP = new MercadoPagoAPI();
        apiMP.abonarCuota();
        return null;
    }

}