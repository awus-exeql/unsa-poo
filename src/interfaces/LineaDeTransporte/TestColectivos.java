package interfaces.LineaDeTransporte;

import java.util.ArrayList;

public class TestColectivos {
    public static void main(){
        ColectivoDiesel coleD = new ColectivoDiesel(50,1,200,2);
        Hibrido coleH = new Hibrido(45,1.2,IElectrico.ALTO_VOLTAJE,150,2);

        ArrayList<Colectivo> arr = new ArrayList<Colectivo>();

        arr.add(coleD);
        arr.add(coleH);

        double nivCont = 0,id = 0;
        Colectivo temp;
        for(int i = 0; i<arr.size(); i++){
            temp = arr.get(i);
            if(temp instanceof IDiesel){
                nivCont = ((IDiesel) temp).getNivelContaminacion();
                id = temp.getID();
            }
            System.out.println("ID: "+id+" | Nivel de contaminacion: "+nivCont);
        }

        ColectivoElectrico coleE = new ColectivoElectrico(55,0.9,IElectrico.BAJO_VOLTAJE);

        System.out.println("Agregamos a la lista un Colectivo Electrico");
        arr.add(coleE);

        System.out.println("Recorremos la lista de nuevo");
        for(int i = 0; i<arr.size(); i++){
            temp = arr.get(i);

            System.out.println("ID: "+temp.getID());

            if(temp instanceof IElectrico){
                double v = ((IElectrico) temp).getVoltaje();
                System.out.println("Voltaje: "+v);
            }
            if(temp instanceof IDiesel){
                double c = ((IDiesel) temp).getNivelContaminacion();
                System.out.println("Nivel de contaminacion: "+c);
            }
        }
    }
}
