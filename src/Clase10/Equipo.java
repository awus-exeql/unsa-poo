package Clase10;

import java.util.ArrayList;

public class Equipo {
    private ArrayList<Jugador> jugadores;

    public Equipo(){
        jugadores = new ArrayList<Jugador>();
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador){
        jugadores.remove(jugador);
    }

    @Override
    public String toString() {
        return "Equipo: "+jugadores;
    }
}
