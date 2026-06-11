package tp3.ejercicio5.formatoLibro;

import tp3.ejercicio5.Autor;
import tp3.ejercicio5.Libro;
import util.Fecha;

import java.util.Calendar;

public class Digital extends Libro {
    private String formato;
    private double peso;

    public Digital(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso, String formato, double peso) {
        super(codigo, titulo, autor, fchPublicacion, fchIngreso);
        this.formato = formato;
        this.peso = peso;
    }

    public String getFormato() {
        return formato;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public double montoAsegurado() {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        int antiguedad = anioActual - this.getFchPublicacion().getAnio();

        if (antiguedad < 0) {
            antiguedad = 0;
        }

        return antiguedad * 100.0;
    }
}