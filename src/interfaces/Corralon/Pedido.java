package interfaces.Corralon;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<PiezaCeramica> piezas;
    private FormaDePago formaDePago;

    public Pedido(){
        piezas = new ArrayList<PiezaCeramica>();
    }

    public void agregarPieza(PiezaCeramica pieza){
        this.piezas.add(pieza);
    }

    public void setFormaDePago(FormaDePago formaDePago){
        this.formaDePago = formaDePago;
    }

    public double calcularTotal(){
        double sum = 0;
        for(int i = 0; i<this.piezas.size(); i++){
            sum += piezas.get(i).getPrecioFinal();
        }
        return sum;
    }

    public void pagar(){
        System.out.println("Total: "+calcularTotal());
        System.out.println("A pagar: "+formaDePago.pagar(calcularTotal()));
    }
}
