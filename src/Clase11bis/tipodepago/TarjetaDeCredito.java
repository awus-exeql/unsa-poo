package Clase11bis.tipodepago;

import Clase11bis.TipoDePago;

public class TarjetaDeCredito extends TipoDePago {
    private double recargo;
    public TarjetaDeCredito(){
        this.recargo = 100;
    }
    @Override
    public double pagar(double monto) {
        return monto+this.recargo;
    }

    public double getRecargo() {
        return recargo;
    }
    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }
}
