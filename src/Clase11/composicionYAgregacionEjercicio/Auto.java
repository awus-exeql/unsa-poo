package Clase11.composicionYAgregacionEjercicio;

public class Auto {
    private Conductor conductor;
    private Motor motor;
    private Tanque tanque;
    private double distanciaRecorrida;

    public Auto(Conductor conductor, double consumoXMin, double distanciaXLitro, double capTotal) {
        this.conductor = conductor;
        this.motor = new Motor(consumoXMin, distanciaXLitro);
        this.tanque = new Tanque(capTotal);
        this.distanciaRecorrida = 0;
    }

    public void mover(){
        if(!tanque.isVacio()){
            if(!motor.isEncendido()){
                motor.setEncendido(true);
            }
            double consumoNecesario = motor.getConsumoXMin();
            double naftaDisponible = tanque.getCapActual();
            if(naftaDisponible >= consumoNecesario){
                tanque.consumir(consumoNecesario);
                this.distanciaRecorrida += (consumoNecesario * motor.getDistanciaXLitro());
            }
            else{
                tanque.consumir(naftaDisponible);
                this.distanciaRecorrida += (naftaDisponible * motor.getDistanciaXLitro());
            }
            if(tanque.isVacio()){
                motor.setEncendido(false);
            }
        }
        else{
            motor.setEncendido(false);
        }
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
    public void cargarNafta(double cantidad) {
        this.tanque.cargar(cantidad);
    }
    public Tanque getTanque() {
        return this.tanque;
    }
    public Conductor getConductor() {
        return conductor;
    }
}
