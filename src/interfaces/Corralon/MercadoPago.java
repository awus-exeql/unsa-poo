package interfaces.Corralon;

public class MercadoPago implements FormaDePago{
    public MercadoPago(){
    }

    @Override
    public double pagar(double monto) {
        return monto-(monto*0.07);
    }
}
