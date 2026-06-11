package Clase11.composicionYAgregacionEjercicio;

public class Tanque {
    private double capTotal;
    private double capActual;
    private boolean vacio;

    public Tanque(double capTotal, double capActual) {
        this.capTotal = capTotal;
        this.capActual = capActual;
        this.vacio = isVacio();
    }
    public Tanque(double capTotal){ // Inicia con el tanque lleno
        this(capTotal,capTotal);
    }

    public double getCapTotal() {
        return capTotal;
    }

    public double getCapActual() {
        return capActual;
    }

    public boolean isVacio() {
        return capActual==0;
    }

    public void consumir(double cantidad){
        if(cantidad>=capActual){
            capActual = 0;
            vacio = true;
        }
        else{
            capActual -= cantidad;
        }
    }

    public void cargar(double cantidad){
        if(isVacio()){
            vacio = false;
        }
        if(capActual+cantidad > capTotal){
            capActual = capTotal;
        }
        else{
            capActual += cantidad;
        }
    }
}
