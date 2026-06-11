package Clase11.composicionEjercicio;

public class Auto {
    private Motor motor;
    private Tanque tanque;
    private double distanciaRecorrida;

    public Auto(double consumoXMin, double distanciaXLitro, double capTotal) {
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
}
