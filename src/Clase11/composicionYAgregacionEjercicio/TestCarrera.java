package Clase11.composicionYAgregacionEjercicio;

public class TestCarrera {
    public static void main(String[] args) {
        // 1. Crear Conductores (independientes)
        Conductor c1 = new Conductor("Juan");
        Conductor c2 = new Conductor("Pedro");

        // 2. Crear Autos asociándoles su Conductor (Agregación) y sus propiedades mecánicas (Composición)
        // Auto 1: consume 1.0 L/min, rinde 10 km/L, tanque de 50 L (Avanza 10 km por minuto)
        Auto autoJuan = new Auto(c1, 1.0, 10.0, 50.0);

        // Auto 2: consume 0.5 L/min, rinde 22 km/L, tanque de 40 L (Avanza 11 km por minuto)
        Auto autoPedro = new Auto(c2, 0.5, 22.0, 40.0);

        // 3. Crear la Carrera con una distancia de 60 km
        Carrera carrera = new Carrera(60.0);

        // 4. Agregar los competidores
        carrera.agregarAuto(autoJuan);
        carrera.agregarAuto(autoPedro);

        // 5. Ejecutar simulación
        carrera.simular();
    }
}
