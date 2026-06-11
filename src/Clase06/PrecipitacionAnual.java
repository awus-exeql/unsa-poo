package Clase06;

public class PrecipitacionAnual {
    private double[] listaPrecipitaciones;
    private int indiceACargar;

    public PrecipitacionAnual(){
        listaPrecipitaciones = new double[12];
        indiceACargar = -1;
    }
    private void incrementarIndice(){
        indiceACargar++;
    }
    public void cargarPrecipActual(double valor){
        incrementarIndice();
        listaPrecipitaciones[indiceACargar] = valor;
    }
    public void cargarPrecipMes(int indice,double valor){

    }
}
