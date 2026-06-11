package Clase10;

import java.util.ArrayList;

public class Tecnico {
    private ArrayList<String> competencias;

    public Tecnico(){
        competencias = new ArrayList<String>();
    }

    public void cargarCompetencia(String competencia){
        competencias.add(competencia);
    }
    public void eliminarCompetencia(){
        if(!competencias.isEmpty()){
            competencias.removeLast();
        }
    }
    public void eliminarCompetencia(String competencia){
        competencias.remove(competencia);
    }
    public int cantidadDeCompetencias(){
        return competencias.size();
    }
    @Override
    public String toString() {
        return "Clase10.Tecnico [competencias=" + competencias.toString() + "]";
    }
}
