package Clase11.composicionEjercicio;

public class TestAuto {
    public static void main(String[] args) {
        // 1. Instanciación del Auto (Composición)
        // Parámetros: consumoXMin = 0.5 litros, distanciaXLitro = 15.0 km, capTotal = 40.0 litros
        // El tanque se inicializa lleno (40.0 litros) según nuestro diseño.
        Auto miAuto = new Auto(0.5, 15.0, 40.0);

        System.out.println("--- Estado Inicial ---");
        imprimirEstado(miAuto);

        // 2. Simulación de movimiento normal
        // Al avanzar 1 minuto, debería consumir 0.5 litros y recorrer (0.5 * 15) = 7.5 km.
        System.out.println("\n--- Avanzando 1 minuto ---");
        miAuto.mover();
        imprimirEstado(miAuto);

        // 3. Forzar el vaciado del tanque para probar el apagado automático
        // Consumimos el remanente de nafta simulando un viaje largo en un bucle
        System.out.println("\n--- Moviendo el auto hasta vaciar el tanque ---");
        while (!miAuto.getTanque().isVacio()) {
            miAuto.mover();
        }
        imprimirEstado(miAuto);

        // 4. Intentar mover el auto sin combustible
        // No debería sumar distancia recorrida.
        System.out.println("\n--- Intentando mover sin nafta ---");
        miAuto.mover();
        imprimirEstado(miAuto);

        // 5. Probar la recarga de nafta
        System.out.println("\n--- Cargando 10 litros de nafta ---");
        miAuto.cargarNafta(10.0);
        imprimirEstado(miAuto);

        // 6. Volver a mover el auto tras la carga
        System.out.println("\n--- Avanzando 1 minuto post-recarga ---");
        miAuto.mover();
        imprimirEstado(miAuto);
    }

    private static void imprimirEstado(Auto auto) {
        System.out.println("Distancia recorrida total: " + auto.getDistanciaRecorrida() + " km");
        System.out.println("Combustible en tanque: " + auto.getTanque().getCapActual() + " litros");
        System.out.println("¿Tanque vacío?: " + auto.getTanque().isVacio());
    }
}
