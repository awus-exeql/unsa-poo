package clasesAbstractas;

public class ListaDeAlumnos extends ListaOrdenada{
    public ListaDeAlumnos(){
        super();
    }

    @Override
    public boolean menor(Object objA, Object objB) {
        Alumno a1 = (Alumno) objA;
        Alumno a2 = (Alumno) objB;
        return a1.getApenom().compareToIgnoreCase(a2.getApenom())<0;
    }

    @Override
    public boolean mayor(Object objA, Object objB) {
        Alumno a1 = (Alumno) objA;
        Alumno a2 = (Alumno) objB;
        return a1.getApenom().compareToIgnoreCase(a2.getApenom())>0;
    }

    @Override
    public boolean igual(Object objA, Object objB) {
        Alumno a1 = (Alumno) objA;
        Alumno a2 = (Alumno) objB;
        return a1.getApenom().equals(a2.getApenom());
    }

    public static void main(){
        ListaOrdenada list = new ListaDeAlumnos();

        list.insertar(new Alumno("Castellanos Agustin"));
        list.insertar(new Alumno("Cacharani Isabella"));
        list.insertar(new Alumno("Bruno Leandro"));
        list.insertar(new Alumno("Salas Abigail"));
        list.insertar(new Alumno("Guzman Karen"));

        System.out.println("Lista hollymolly\n"+list);
        System.out.println("Tamaño: "+list.getTam());

        System.out.println("\nEliminando el Alumno: Salas Abigail");
        list.eliminar(new Alumno("Salas Abigail"));

        System.out.println("\nLista hollymolly\n"+list);
        System.out.println("Tamaño: "+list.getTam());
    }
}
