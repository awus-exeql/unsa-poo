import java.util.Random;

public class VentaSemanal {
    private double[] ventas;

    public VentaSemanal(){
        ventas = new double[0];
    }
    public VentaSemanal(int tam){
        ventas = new double[tam];
    }
    public VentaSemanal(double[] ventas) {
        this.ventas = ventas;
    }

    public double[] getVentas() {
        return ventas;
    }

    public void setVentas(double[] ventas) {
        this.ventas = ventas;
    }

    public void cargarVentas(){
        Random rnd = new Random();
        for(int i=0; i<ventas.length;i++) {
            ventas[i] = rnd.nextDouble(10 - 0 + 1) + 0;
            System.out.println("random "+i+": "+ventas[i]);
        }
    }
    public double totalVentaSemanal(){
        double s = 0;
        for(int i = 0; i<ventas.length; i++)
            s+=ventas[i];
        return s;
    }
    public double promedioVentaSemanal(){
        double s = 0;
        int t = ventas.length;
        if(t>0){
            for(int i = 0; i<ventas.length; i++)
                s+=ventas[i];
            return s/ventas.length;
        }
        else
            return 0;
    }
    public String diaConMasVentas(){
        double may = ventas[0];
        int p = 0;
        String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        for(int i = 1; i< ventas.length;i++){
            if(ventas[i]>may) {
                p = i;
                may = ventas[i];
            }
        }
        return "El dia con mas ventas es: "+dias[p];
    }
}
