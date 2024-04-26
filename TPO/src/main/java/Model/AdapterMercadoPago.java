package Model;

/**
 * 
 */
public class AdapterMercadoPago {

    private MercadoPagoAPI apiMP;

    public Void abonarCuota(Curso curso) {
        MercadoPagoAPI apiMP = new MercadoPagoAPI();
        apiMP.abonarCuota(curso);
        return null;
    }

}