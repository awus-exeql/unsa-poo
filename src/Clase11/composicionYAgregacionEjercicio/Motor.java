package Clase11.composicionYAgregacionEjercicio;

public class Motor {
    private double consumoXMin;
    private double distanciaXLitro;
    private boolean encendido;

    public Motor(double consumoXMin, double distanciaXLitro, boolean encendido) {
        this.consumoXMin = consumoXMin;
        this.distanciaXLitro = distanciaXLitro;
        this.encendido = encendido;
    }

    public Motor(double consumoXMin, double distanciaXLitro) {
        this.consumoXMin = consumoXMin;
        this.distanciaXLitro = distanciaXLitro;
        this.encendido = false;
    }

    public double getConsumoXMin() {
        return consumoXMin;
    }

    public double getDistanciaXLitro() {
        return distanciaXLitro;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
}
