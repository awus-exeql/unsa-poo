package tp3.ejercicio5.a;

import tp3.ejercicio5.Autor;
import tp3.ejercicio5.Libro;
import tp3.ejercicio5.b.TablaAutores;
import tp3.ejercicio5.b.TablaLibros;
import tp3.ejercicio5.formatoLibro.Fisico;
import util.Fecha;
import java.util.Calendar;

public class Sucursal {
    private String nombre;
    private TablaLibros librosEnSuc;
    private TablaPrestamos librosPrestados;
    private TablaAutores totalidadAutores;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.librosEnSuc = new TablaLibros();
        this.librosPrestados = new TablaPrestamos();
        this.totalidadAutores = new TablaAutores();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void prestarLibro(Libro l, Sucursal s){
        // Obtenemos la fecha actual usando el calendario del sistema
        Calendar cal = Calendar.getInstance();

        // El calendario cuenta los meses de 0 a 11, sumamos 1
        Fecha fchActual = new Fecha(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));

        // Avanzamos un mes para la fecha de devolución
        cal.add(Calendar.MONTH, 1);
        Fecha fchDevolucion = new Fecha(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));

        // Registramos el préstamo y removemos el libro físico de esta sucursal
        Prestamo nuevoP = new Prestamo(l, s, fchDevolucion);
        this.librosPrestados.nuevoPrestamo(nuevoP);
        this.librosEnSuc.eliminarLibro(l);
    }

    public TablaLibros librosNacionalidad(String nac) {
        TablaLibros resultado = new TablaLibros();

        for (int i = 0; i < this.librosEnSuc.cantidadLibros(); i++) {
            Libro libro = this.librosEnSuc.getLibro(i);
            if (libro.getAutor().getNacionalidad().equalsIgnoreCase(nac)) {
                resultado.insertarLibro(libro);
            }
        }
        return resultado;
    }

    public TablaAutores autoresPopulares(int n) {
        TablaAutores resultado = new TablaAutores();

        for (int i = 0; i < this.totalidadAutores.cantidadAutores(); i++) {
            Autor autor = this.totalidadAutores.recuperarAutor(i);

            // Contar ejemplares en stock en la sucursal
            int librosEnSede = 0;
            for (int j = 0; j < this.librosEnSuc.cantidadLibros(); j++) {
                if (this.librosEnSuc.getLibro(j).getAutor().equals(autor)) {
                    librosEnSede++;
                }
            }

            // Verificar si tiene préstamos activos
            boolean tienePrestamo = false;
            for (int k = 0; k < this.librosPrestados.getCantidad(); k++) {
                if (this.librosPrestados.getPrestamo(k).getLibro().getAutor().equals(autor)) {
                    tienePrestamo = true;
                    break;
                }
            }

            if (librosEnSede > n && tienePrestamo) {
                resultado.insertarAutor(autor);
            }
        }

        return resultado;
    }

    public Autor autorLibroMayorPeso() {
        if (!this.librosEnSuc.hayLibros()) {
            return null;
        }

        Fisico libroMayorPeso = null;
        int indiceInicio = 0;

        // Buscamos el primer libro físico disponible para empezar la comparación
        for (int i = 0; i < this.librosEnSuc.cantidadLibros(); i++) {
            if (this.librosEnSuc.getLibro(i) instanceof Fisico) {
                libroMayorPeso = (Fisico) this.librosEnSuc.getLibro(i);
                indiceInicio = i;
                break;
            }
        }

        // Si no se encontró ningún libro físico, retorna null
        if (libroMayorPeso == null) {
            return null;
        }

        // Ciclo clásico comparativo
        for (int i = indiceInicio; i < this.librosEnSuc.cantidadLibros(); i++) {
            Libro libroActual = this.librosEnSuc.getLibro(i);
            if (libroActual instanceof Fisico) {
                Fisico libroFisicoActual = (Fisico) libroActual;
                if (libroFisicoActual.getPeso() > libroMayorPeso.getPeso()) {
                    libroMayorPeso = libroFisicoActual;
                }
            }
        }

        return libroMayorPeso.getAutor();
    }

    public double montoAseguradoPorAutor(String nombre) {
        double montoTotal = 0;

        // 1. Recorremos los libros disponibles en la sucursal
        for (int i = 0; i < this.librosEnSuc.cantidadLibros(); i++) {
            Libro libro = this.librosEnSuc.getLibro(i);
            if (libro.getAutor().getNombre().equalsIgnoreCase(nombre)) {
                montoTotal += libro.montoAsegurado();
            }
        }

        // 2. Recorremos los libros de la sucursal que se encuentran prestados
        for (int i = 0; i < this.librosPrestados.getCantidad(); i++) {
            Libro libro = this.librosPrestados.getPrestamo(i).getLibro();
            if (libro.getAutor().getNombre().equalsIgnoreCase(nombre)) {
                montoTotal += libro.montoAsegurado();
            }
        }

        return montoTotal;
    }

    public TablaLibros mayorMontoAsegurado(int n) {
        int totalLibros = this.librosEnSuc.cantidadLibros();

        // Estructura lineal clásica (arreglo) para poder aplicar el ordenamiento
        Libro[] temp = new Libro[totalLibros];
        for (int i = 0; i < totalLibros; i++) {
            temp[i] = this.librosEnSuc.getLibro(i);
        }

        // Algoritmo de ordenamiento clásico (Burbuja) de mayor a menor monto
        for (int i = 0; i < totalLibros - 1; i++) {
            for (int j = 0; j < totalLibros - i - 1; j++) {
                if (temp[j].montoAsegurado() < temp[j + 1].montoAsegurado()) {
                    Libro aux = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = aux;
                }
            }
        }

        TablaLibros resultado = new TablaLibros();
        // Determinamos el corte para no desbordar si n es mayor que los libros existentes
        int limite = (n > totalLibros) ? totalLibros : n;

        for (int i = 0; i < limite; i++) {
            resultado.insertarLibro(temp[i]);
        }

        return resultado;
    }
}
