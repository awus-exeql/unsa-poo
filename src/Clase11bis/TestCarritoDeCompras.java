package Clase11bis;

import Clase11bis.formato.*;
import Clase11bis.tipodepago.*;
import java.util.ArrayList;

public class TestCarritoDeCompras {
    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Autor Anonimo"));

        // Definición de libros con sus respectivas reglas de precio
        Libro l1 = new Libro(101, autores, new Papel("tapa dura"), 1000.0);  // Precio: 1200.0 (1000 + 20%)
        Libro l2 = new Libro(102, autores, new Papel("tapa blanda"), 1000.0); // Precio: 1000.0 (nominal)
        Libro l3 = new Libro(103, autores, new Digital("pdf"), 1000.0);       // Precio: 850.0  (1000 - 15%)
        Libro l4 = new Libro(104, autores, new Digital("mobi"), 1000.0);      // Precio: 950.0  (1000 - 5%)

        CarritoDeCompra carrito = new CarritoDeCompra();

        // Agregar libros (incluyendo un repetido)
        carrito.agregarLibro(l1);
        carrito.agregarLibro(l2);
        carrito.agregarLibro(l3);
        carrito.agregarLibro(l4);
        carrito.agregarLibro(l1); // Repetido Tapa Dura (1200.0)

        // Total esperado: 1200 + 1000 + 850 + 950 + 1200 = 5200.0
        System.out.println("--- Evaluando Carrito con Repetidos ---");
        System.out.println("Total calculado: $" + carrito.calcularTotal());

        System.out.println("\n--- Probando eliminar un libro repetido ---");
        carrito.eliminarLibro(l1); // Debe eliminar solo uno de los dos con ISBN 101
        // Nuevo total esperado: 5200 - 1200 = 4000.0
        System.out.println("Total tras eliminación: $" + carrito.calcularTotal());

        System.out.println("\n--- Simulación de Pagos ---");

        System.out.println("[Efectivo]");
        carrito.pagar(new Efectivo()); // Esperado: 4000 - 10% = 3600.0

        System.out.println("\n[MercadoPago]");
        carrito.pagar(new MercadoPago()); // Esperado: 4000 + 15% = 4600.0

        System.out.println("\n[Tarjeta de Crédito]");
        carrito.pagar(new TarjetaDeCredito()); // Esperado: 4000 + 100 = 4100.0
    }
}
