package Model;

import java.util.Scanner;

public class ControladorPagos {
    private static ControladorPagos instancia;
    private EstrategiaPago estrategia;

    private ControladorPagos() {

    }
    public static ControladorPagos getInstancia() {
        if (instancia == null){
            instancia = new ControladorPagos();
        }
        return instancia;
    }
    public Void abonarCuota() {
        Scanner scanner = new Scanner(System.in);
        EstrategiaPago mercadoPago = new MercadoPago();
        setEstrategia(mercadoPago);

        System.out.print("Por predeterminado el pago se relizara por MercadoPago pero puede cambiar a otros servicios\n");
        System.out.print("Seleccione 1 para usar Binance , 2 para Pago mis cuentas o 0 para continuar con Mercado Pago\n");
        int tipoPago = scanner.nextInt();
        switch (tipoPago) {
            case 1:
                EstrategiaPago binance = new Binance();
                setEstrategia(binance);
                binance.abonarCuota();
                break;
            case 2:
                EstrategiaPago pagoMisCuentas = new PagoMisCuentas();
                setEstrategia(pagoMisCuentas);
                pagoMisCuentas.abonarCuota();
                break;
            case 0:
                mercadoPago.abonarCuota();
                break;
        }
        scanner.close();
        return null;
    }


    private void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }
}
