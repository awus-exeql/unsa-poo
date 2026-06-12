package interfaces.Corralon;

public class TarjetaDeCredito implements FormaDePago{
    public TarjetaDeCredito() {
    }

    @Override
    public double pagar(double monto) {
        return monto+240;
    }
}
