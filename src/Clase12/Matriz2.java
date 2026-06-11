package Clase12;

public class Matriz2 extends Matriz {
    private int n;

    // Constructor estándar: inicializa la matriz y asigna un valor seguro a n
    public Matriz2(int filas, int columnas) {
        super(filas, columnas);
        this.n = 2; // Valor por defecto estándar para MaxPooling
    }

    // Constructor completo
    public Matriz2(int m, int nFilasColumnas, int n2) {
        super(m, nFilasColumnas);
        this.n = n2;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        if (getFilas() % n == 0 && getColumnas() % n == 0) {
            this.n = n;
        } else {
            System.out.println("La cantidad de filas y columnas deben ser divisibles por N!");
        }
    }

    /**
     * Aplica la reducción por MaxPooling de tamaño N x N.
     * Retorna una instancia de la clase base Matriz.
     */
    public Matriz aplicarMaxPooling() {
        // Validar precondiciones dimensionales
        if (this.n <= 0 || getFilas() % this.n != 0 || getColumnas() % this.n != 0) {
            System.out.println("Error: Dimensiones de la matriz no son divisibles por N.");
            return null;
        }

        // 1. Dimensiones de la matriz reducida
        int nuevasFilas = getFilas() / this.n;
        int nuevasColumnas = getColumnas() / this.n;

        // 2. Se crea una Matriz estándar para retornar el resultado
        Matriz resultado = new Matriz(nuevasFilas, nuevasColumnas);

        // 3. Recorrido indexado de la matriz destino
        for (int i = 0; i < nuevasFilas; i++) {
            for (int j = 0; j < nuevasColumnas; j++) {

                // Mapeo matemático del inicio de la ventana de NxN en la matriz original
                int filaOrigen = i * this.n;
                int colOrigen = j * this.n;

                // 4. Inicializar el patrón de búsqueda del máximo (Tipo double)
                char mayor = getValor(filaOrigen, colOrigen);

                // 5. Bucles internos que barren estrictamente la submatriz de NxN
                for (int k = 0; k < this.n; k++) {
                    for (int l = 0; l < this.n; l++) {
                        char valorActual = getValor(filaOrigen + k, colOrigen + l);

                        // Comparación directa de tipos primitivos double (los cambie a char)
                        if (valorActual > mayor) {
                            mayor = valorActual;
                        }
                    }
                }

                // 6. Asignación del valor máximo en la celda reducida
                resultado.setValor(i, j, mayor);
            }
        }
        return resultado;
    }
}
