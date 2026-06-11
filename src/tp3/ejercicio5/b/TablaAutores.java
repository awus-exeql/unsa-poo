package tp3.ejercicio5.b;

import tp3.ejercicio5.Autor;

import java.util.ArrayList;
import java.util.List;

public class TablaAutores {
    private List<Autor> autores;
    private int cantidad;

    public TablaAutores(List<Autor> autores, int cantidad) {
        this.autores = autores;
        this.cantidad = cantidad;
    }

    public TablaAutores(){
        this(new ArrayList<>(),0);
    }

    public void insertarAutor(Autor autor){
        this.autores.add(autor);
    }

    public int cantidadAutores(){
        return this.autores.size();
    }

    public boolean estaAutor(Autor autor){
        for(Autor otro : this.autores){
            if(otro.equals(autor))
                return true;
        }
        return false;
    }

    public boolean hayAutores(){
        return !this.autores.isEmpty();
    }

    public Autor recuperarAutor(int pos){
        return autores.get(pos);
    }
    public Autor recuperarAutor(String nombre){
        if(hayAutores()){
            for(Autor a : autores){
                if(a.mismoAutor(nombre)){
                    return a;
                }
            }
            System.out.println("No encontrado.");
        }
        else{
            System.out.println("No hay autores cargados.");
        }
        return null;
    }

    public TablaAutores autoresNac(String nac){
        TablaAutores ta = new TablaAutores();
        for(Autor a : autores){
            if(a.getNacionalidad().equals(nac)){
                ta.insertarAutor(a);
            }
        }
        if(ta.cantidadAutores()<1){
            System.out.println("No encontramos autores.");
        }
        return ta;
    }
}
