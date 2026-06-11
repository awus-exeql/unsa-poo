package clase13_ClasesAbstractas;

public class ListaDeEnteros extends ListaOrdenada{
    public ListaDeEnteros(){
        super();
    }

    @Override
    public boolean menor(Object objA, Object objB) {
        int a = (int)objA;
        int b = (int)objB;
        return a<b;
    }

    @Override
    public boolean mayor(Object objA, Object objB) {
        int a = (int)objA;
        int b = (int)objB;
        return a>b;
    }

    @Override
    public boolean igual(Object objA, Object objB) {
        int a = (int)objA;
        int b = (int)objB;
        return a==b;
    }

    public static void main(){
        ListaDeEnteros list = new ListaDeEnteros();

        list.insertar(2);
        list.insertar(9);
        list.insertar(4);
        list.insertar(7);
        list.insertar(3);

        System.out.println("Lista hollymolly\n"+list);
        System.out.println("Tamaño: "+list.getTam());

        System.out.println("\nEliminando el elemento: "+7);
        list.eliminar(7);

        System.out.println("\nLista hollymolly\n"+list);
        System.out.println("Tamaño: "+list.getTam());
    }
}
