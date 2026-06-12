package interfaces.Corralon;

public class Azulejo extends PiezaCeramica{
    private int medida;

    public Azulejo(int codigo, double precioBase, int medida) {
        super(codigo, precioBase);
        this.medida = medida;
    }

    @Override
    public double getPrecioFinal() {
        return this.getPrecioBase()+(3.05*this.medida);
    }
}
