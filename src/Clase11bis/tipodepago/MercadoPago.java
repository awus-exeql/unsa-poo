package Clase11bis.tipodepago;

import Clase11bis.TipoDePago;

public class MercadoPago extends TipoDePago {
    private double porcRecargo;
    public MercadoPago(){
        this.porcRecargo = 0.15;
    }

    @Override
    public double pagar(double monto) {
        return monto+(monto*porcRecargo);
    }

    public double getPorcRecargo() {
        return porcRecargo;
    }
    public void setPorcRecargo(double porcRecargo) {
        this.porcRecargo = porcRecargo;
    }
}
