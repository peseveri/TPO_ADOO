package Model;

public class AdapterBinance implements EstrategiaPago {
    private BinanceApi apiBNC;
    public AdapterBinance() {
        this.apiBNC = new BinanceApi();
    }
    @Override
    public void abonarCuota(){
        apiBNC.abonarCuota();
    }
}
