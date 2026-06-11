package tp3.ejercicio5.formatoLibro;

import tp3.ejercicio5.Autor;
import tp3.ejercicio5.Libro;
import util.Fecha;

import java.util.Calendar;

public class Fisico extends Libro {
    private int paginas;
    private int peso;

    public Fisico(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso, int paginas, int peso) {
        super(codigo, titulo, autor, fchPublicacion, fchIngreso);
        this.paginas = paginas;
        this.peso = peso;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public double montoAsegurado() {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        int antiguedad = anioActual - this.getFchPublicacion().getAnio();

        if (antiguedad < 0) {
            antiguedad = 0;
        }

        double componenteAntiguedad = antiguedad * 200.0;
        double componentePeso = (this.peso / 100.0) * 50.0;

        return componenteAntiguedad + componentePeso;
    }
}
