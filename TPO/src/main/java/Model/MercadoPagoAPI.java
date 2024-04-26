package Model;


public class MercadoPagoAPI {

    public Void abonarCuota(Curso curso) {
        System.out.println("Bienvenido a Mercado Pago");
        System.out.println("Se proceso correctamente el pago del curso: " + curso.getId() + " por un total de: " + curso.getPrecio() + "$");
        return null;
    }


}