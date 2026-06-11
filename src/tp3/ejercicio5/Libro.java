package tp3.ejercicio5;

import util.Fecha;

public abstract class Libro {
    private String codigo;
    private String titulo;
    private Autor autor;
    private Fecha fchPublicacion;
    private Fecha fchIngreso;

    public Libro(String codigo, String titulo, Autor autor, Fecha fchPublicacion, Fecha fchIngreso) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.fchPublicacion = fchPublicacion;
        this.fchIngreso = fchIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Fecha getFchPublicacion() {
        return fchPublicacion;
    }

    public Fecha getFchIngreso() {
        return fchIngreso;
    }

    public boolean mismoAutor(String autor){
        return this.autor.mismoAutor(autor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Libro) {
            Libro libro = (Libro) obj;
            return this.codigo.equals(libro.getCodigo());
        } else {
            return false;
        }
    }

    public abstract double montoAsegurado();
}
