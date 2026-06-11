package Clase10;
import util.Fecha;

import java.util.Objects;

public class Jugador{
    private int dni;
    private String nombre;
    private Fecha fchNac;

    public Jugador(int dni, String nombre,Fecha fchNac){
        this.dni = dni;
        this.nombre = nombre;
        this.fchNac = fchNac;
    }
    public Jugador(int dni,String nombre){
        this.dni = dni;
        this.nombre = nombre;
        this.fchNac = new Fecha();
    }

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Fecha getFchNac() {
        return fchNac;
    }
    public void setFchNac(Fecha fchNac) {
        this.fchNac = fchNac;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Jugador){
            return ( this.dni == ((Jugador) o).getDni() );
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, fchNac);
    }
}
