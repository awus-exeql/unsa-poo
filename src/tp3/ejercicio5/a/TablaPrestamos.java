package tp3.ejercicio5.a;

import tp3.ejercicio5.Libro;

import java.util.ArrayList;
import java.util.List;

public class TablaPrestamos {
    private List<Prestamo> prestamos;
    private int cantidad;

    public TablaPrestamos(List<Prestamo> prestamos, int cantidad) {
        this.prestamos = prestamos;
        this.cantidad = cantidad;
    }

    public TablaPrestamos(List<Prestamo> prestamos){
        this(prestamos,prestamos.size());
    }

    public TablaPrestamos() {
        this(new ArrayList<Prestamo>(),0);
    }

    public void nuevoPrestamo(Prestamo p){
        this.prestamos.add(p);
        this.cantidad++;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Prestamo getPrestamo(int pos){
        return this.prestamos.get(pos);
    }

    public boolean estaPrestado(Libro libro){
        for(Prestamo prestamo: this.prestamos){
            if(prestamo.getLibro().equals(libro)){
                return true;
            }
        }
        return false;
    }

    public boolean hayPrestamos(){
        return !this.prestamos.isEmpty();
    }
}
