package interfaces.LineaDeTransporte;

public class Hibrido extends Colectivo implements IDiesel,IElectrico{
    double voltaje,distancia,nivelContamincaion;

    public Hibrido(int capacidad, double costo, double voltaje, double distancia, double nivelContamincaion) {
        super(capacidad, costo);
        this.voltaje = voltaje;
        this.distancia = distancia;
        this.nivelContamincaion = nivelContamincaion;
    }

    @Override
    public double getAcel() {
        return 4.0;
    }

    @Override
    public double getDistancia() {
        return this.distancia;
    }

    @Override
    public double getNivelContaminacion() {
        return this.nivelContamincaion;
    }

    @Override
    public double getVoltaje() {
        return this.voltaje;
    }
}
