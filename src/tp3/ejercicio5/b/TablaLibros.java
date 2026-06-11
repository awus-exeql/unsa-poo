package tp3.ejercicio5.b;

import tp3.ejercicio5.Libro;

import java.util.ArrayList;

public class TablaLibros {
    private ArrayList<Libro> libros;
    private int cantidad;

    public TablaLibros(ArrayList<Libro> libros, int cantidad) {
        this.libros = libros;
        this.cantidad = cantidad;
    }

    public TablaLibros(){
        this(new ArrayList<Libro>(),0);
    }

    public void insertarLibro(Libro libro){
        this.libros.add(libro);
    }

    public void eliminarLibro(Libro libro){
        this.libros.remove(libro);
    }

    public int cantidadLibros(){
        return this.libros.size();
    }

    public boolean existeLibro(Libro libro){
        for(Libro otro: this.libros){
            if(otro.equals(libro)){
                return true;
            }
        }
        return false;
    }

    public boolean estaLlena(){
        return libros.size()==cantidad;
    }

    public boolean hayLibros(){
        return !this.libros.isEmpty();
    }

    public Libro recuperarLibro(String codigo){
        if(cantidadLibros()>0){
            for(Libro lib: this.libros){
                if(lib.getCodigo().equals(codigo))
                    return lib;
            }
        }
        else{
            System.out.println("Error recuperarLibro. Tabla de libros vacia..");
        }
        return null;
    }

    public TablaLibros librosAutor(String nombre){
        TablaLibros libros = new TablaLibros();
        for(Libro lib: this.libros){
            if(lib.getAutor().mismoAutor(nombre)){
                libros.insertarLibro(lib);
            }
        }
        return libros;
    }

    public Libro getLibro(int pos) {
        return this.libros.get(pos);
    }
}
