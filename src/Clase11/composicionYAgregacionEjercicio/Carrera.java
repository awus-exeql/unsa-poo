package Clase11.composicionYAgregacionEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private List<Auto> autos;
    private double distancia;

    public Carrera(double distancia) {
        this.distancia = distancia;
        this.autos = new ArrayList<>();
    }

    public void agregarAuto(Auto auto) {
        this.autos.add(auto);
    }

    public void simular() {
        if (autos.isEmpty()) {
            System.out.println("No hay autos inscriptos en la carrera.");
        }
        else{
            boolean hayGanador = false;
            int minuto = 0;

            System.out.println("=== Inicio de la Carrera (Distancia a recorrer: " + this.distancia + " km) ===");

            while (!hayGanador) {
                minuto++;
                System.out.println("\n--- Minuto " + minuto + " ---");

                for (int i = 0; i < autos.size(); i++) {
                    Auto auto = autos.get(i);

                    auto.mover();
                    System.out.println("Auto de " + auto.getConductor().getNombre() +
                            " - Distancia: " + auto.getDistanciaRecorrida() + " km" +
                            " | Combustible: " + auto.getTanque().getCapActual() + " L");

                    if (auto.getDistanciaRecorrida() >= this.distancia) {
                        hayGanador = true;
                    }
                }

                if (todosSinCombustible()) {
                    System.out.println("\nTodos los autos se quedaron sin combustible antes de terminar.");
                    break;
                }
            }

            determinarGanador();
        }
    }

    private boolean todosSinCombustible() {
        for (int i = 0; i < autos.size(); i++) {
            Auto auto = autos.get(i);
            if (!auto.getTanque().isVacio()) {
                return false;
            }
        }
        return true;
    }

    private void determinarGanador() {
        Auto ganador = autos.getFirst();
        for (int i = 1; i < autos.size(); i++) {
            Auto auto = autos.get(i);
            if (auto.getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {
                ganador = auto;
            }
        }
        System.out.println("\n====================================");
        System.out.println("GANADOR: " + ganador.getConductor().getNombre() +
                " con una distancia total de " + ganador.getDistanciaRecorrida() + " km.");
        System.out.println("====================================");
    }
}
