package interfaces.Corralon;

public class PagoFacil implements FormaDePago{
    public PagoFacil() {
    }

    @Override
    public double pagar(double monto) {
        return monto*1.10;
    }
}
