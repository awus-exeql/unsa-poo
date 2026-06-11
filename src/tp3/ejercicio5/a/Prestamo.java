package tp3.ejercicio5.a;

import tp3.ejercicio5.Libro;
import util.Fecha;

public class Prestamo {
    private Libro libro;
    private Sucursal destino;
    private Fecha fchDevolucion;

    public Prestamo(Libro libro, Sucursal destino, Fecha fchDevolucion) {
        this.libro = libro;
        this.destino = destino;
        this.fchDevolucion = fchDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public Sucursal getDestino() {
        return destino;
    }

    public Fecha getFchDevolucion() {
        return fchDevolucion;
    }
}
