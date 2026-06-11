package clase13_ClasesAbstractas;

import java.util.ArrayList;

public abstract class ListaOrdenada {
    private ArrayList<Object> lista;

    public ListaOrdenada(){
        lista = new ArrayList<Object>();
    }

    public int getTam(){
        return lista.size();
    }

    public boolean estaVacia(){
        return lista.isEmpty();
    }

    public abstract boolean menor(Object objA,Object objB); // Compara si el ObjA es menor que el ObjB
    public abstract boolean mayor(Object objA,Object objB); // Compara si el ObjA es mayor que el ObjB
    public abstract boolean igual(Object objA,Object objB); // Compara si el ObjA es igual que el ObjB

    public int posicionDe(Object obj){
        if(!estaVacia()){
            if(igual(obj,lista.getFirst())){
                return 0;
            }
            else{
                if(igual(obj,lista.getLast())){
                    return getTam()-1;
                }
                else{
                    int i = 1;
                    while(i<getTam()-1){
                        if(igual(obj,lista.get(i)))
                            return i;
                        i++;
                    }
                    return -1;
                }
            }
        }
        else{
            System.out.println("Error posicionDe. Lista vacia..");
            return -1;
        }
    }

    public void insertar(Object obj){
        if(!estaVacia()){
            if(menor(obj,lista.getFirst())){
                lista.addFirst(obj);
            }
            else{
                if(mayor(obj,lista.getLast())){
                    lista.addLast(obj);
                }
                else{
                    int i = 0;
                    while( i<lista.size() && (mayor(obj,lista.get(i)) || igual(obj,lista.get(i))) ){
                        i++;
                    }
                    lista.add(i,obj);
                }
            }
        }
        else{
            lista.add(obj);
        }
    }

    public void eliminar(Object obj){
        int posicion = busquedaBinaria(obj);
        if(posicion != -1){
            lista.remove(posicion);
        }
        else{
            System.out.println("Error eliminar. Objeto no encontrado..");
        }
    }
    private int busquedaBinaria(Object obj){
        int ini = 0;
        int fin = getTam()-1;
        int med = (ini+fin)/2;
        while(ini<=fin && !igual(obj,lista.get(med))){
            if(menor(obj,lista.get(med))){
                fin = med-1;
            }
            else{
                ini = med+1;
            }
            med = (ini+fin)/2;
        }
        if(ini<=fin){
            return med;
        }
        else{
            return -1;
        }
    }

    public boolean esta(Object obj){
        return busquedaBinaria(obj) != -1;
    }

    @Override
    public String toString(){
        if (estaVacia()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i));
            if (i < lista.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
