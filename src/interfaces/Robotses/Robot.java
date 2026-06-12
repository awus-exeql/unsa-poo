package interfaces.Robotses;

public class Robot {
    String nombre;
    boolean encendido;
    Coordenada posicion;
    ComportamientoVigilancia compVigilancia;
    ComportamientoVuelo compVuelo;

    public Robot(String nombre){
        this.nombre = nombre;

    }

    public void encender(){
        this.encendido = true;
    }

    public void apagar(){
        this.encendido = false;
    }

    public boolean estaEncendido(){
        return this.encendido;
    }

    public void trabajar(){

    }

    public void realizarVigilancia(){
        this.compVigilancia.vigilar();
    }

    public void realizarVuelo(){
        this.compVuelo.volar();
    }

    public void setCompVigilancia(ComportamientoVigilancia cVig){
        this.compVigilancia = cVig;
    }

    public void setCompVuelo(ComportamientoVuelo cVuelo){
        this.compVuelo = cVuelo;
    }

    public void irAPosicion(Coordenada posicion){
        this.posicion = posicion;
    }

    @Override
    public String toString(){
        return "Nombre: "+this.nombre;
    }
}
