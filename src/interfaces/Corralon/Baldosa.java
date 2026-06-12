package interfaces.Corralon;

public class Baldosa extends PiezaCeramica{
    private int peso;

    public Baldosa(int codigo, double precioBase, int peso) {
        super(codigo, precioBase);
        this.peso = peso;
    }

    @Override
    public double getPrecioFinal() {
        return this.getPrecioBase()+(0.034*this.peso);
    }
}
