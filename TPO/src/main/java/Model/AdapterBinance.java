package Model;

public class AdapterBinance implements EstrategiaPago {
    BinanceApi apiBNC;

    public AdapterBinance() {
        this.apiBNC = new BinanceApi();
    }

    @Override
    public void abonarCuota(){
        apiBNC.abonarCuota();
    }
}
