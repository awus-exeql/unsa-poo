package interfaces.Corralon;

public class TestCorralon {
    public static void main(){
        Pedido pedido = new Pedido();

        Azulejo azulejo = new Azulejo(1,500,10);
        Baldosa baldosa = new Baldosa(2,900,200);

        pedido.agregarPieza(azulejo);
        pedido.agregarPieza(baldosa);

        pedido.setFormaDePago(new TarjetaDeCredito());

        pedido.pagar();
    }
}
