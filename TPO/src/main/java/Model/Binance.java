package Model;

public class Binance implements EstrategiaPago{
    AdapterBinance adapterBinance;
    public Binance() {
        this.adapterBinance = new AdapterBinance();
    }
    @Override
    public void abonarCuota() {
        adapterBinance.abonarCuota();
    }
}
