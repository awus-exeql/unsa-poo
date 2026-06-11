package Clase08.Clinica;

import util.Fecha;

public class Paciente {
    private String nombre,domicilio,telefono;
    private int dni;
    private Fecha fecha;

    public Paciente(){
        telefono = domicilio = nombre = "";
        dni = 0;
        fecha = new Fecha();
    }
    public Paciente(String nombre,int dni,String domicilio,String telefono,Fecha fecha){
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = domicilio;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

}
