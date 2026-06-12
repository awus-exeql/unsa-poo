package interfaces.LineaDeTransporte;

public class ColectivoElectrico extends Colectivo implements IElectrico{
    double voltaje;

    public ColectivoElectrico(int capacidad, double costo, double voltaje) {
        super(capacidad, costo);
        this.voltaje = voltaje;
    }

    @Override
    public double getAcel() {
        return 5.0;
    }

    @Override
    public double getVoltaje() {
        return this.voltaje;
    }
}
