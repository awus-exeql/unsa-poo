package Clase12;

public class Matriz1 extends Matriz{

    public Matriz1(int m, int n) {
        super(m, n);
    }

    public void espejo(){
        int ini;
        int fin;
        char aux;

        for(int fila = 0; fila<getFilas(); fila++){
            ini = 0;
            fin = getColumnas()-1;
            while(ini<fin){
                aux = getValor(fila,ini);
                setValor(fila,ini, getValor(fila,fin) );
                setValor(fila,fin, aux);
                ini++;
                fin--;
            }
        }
    }
}
