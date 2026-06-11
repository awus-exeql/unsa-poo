package Clase12;

public class TestMatrices {
    public static void main(){
        Matriz1 matriz = new Matriz1(3,5);
        matriz.cargarAleatorio();
        System.out.println(matriz);
        System.out.println("\n Aplicando el metodo espejo \n");
        matriz.espejo();
        System.out.println(matriz);
    }
}
