package interfaces.Corralon;

public abstract class PiezaCeramica {
    private int codigo;
    private double precioBase;

    public PiezaCeramica(int codigo, double precioBase){
        this.codigo = codigo;
        this.precioBase = precioBase;
    }

    public double getPrecioBase(){
        return this.precioBase;
    }

    public abstract double getPrecioFinal();
}
