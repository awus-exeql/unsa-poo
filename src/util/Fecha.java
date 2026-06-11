package util;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Constructor
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    public Fecha(){
        dia=mes=anio=0;
    }

    // Getters
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    public boolean fechaIndefinida(){
        return (dia==0&&mes==0&&anio==0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Fecha){
            Fecha otro = (Fecha)obj;
            return dia==otro.getDia()&&mes==otro.getMes()&&anio==otro.getAnio();
        }
        else{
            return false;
        }
    }
}
