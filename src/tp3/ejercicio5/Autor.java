package tp3.ejercicio5;

import util.Fecha;

public class Autor {
    private String nombre;
    private String nacionalidad;
    private Fecha fchNac;
    private Fecha fchFall;

    public Autor(String nombre, String nacionalidad, Fecha fchNac, Fecha fchFall) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fchNac = fchNac;
        this.fchFall = fchFall;
    }

    public Autor(String nombre, String nacionalidad, Fecha fchNac) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fchNac = fchNac;
        this.fchFall = new Fecha();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Fecha getFchNac() {
        return fchNac;
    }

    public Fecha getFchFall() {
        if(fchFall.fechaIndefinida())
            System.out.println("Aun no murio bro");
        return fchFall;
    }

    public void setFchFall(Fecha fchFall) {
        this.fchFall = fchFall;
    }

    public boolean mismoAutor(String nombre){
        return this.nombre.equals(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Autor){
            Autor otro = (Autor) obj;
            return nombre.equals(otro.getNombre())&&nacionalidad.equals(otro.getNacionalidad())&&
                    fchNac.equals(otro.getFchNac())&&fchFall.equals(otro.getFchFall());
        }
        else{
            return false;
        }
    }
}
