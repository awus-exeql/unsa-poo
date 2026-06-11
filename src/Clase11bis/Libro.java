package Clase11bis;

import Clase11bis.formato.Digital;
import Clase11bis.formato.Papel;

import java.util.ArrayList;

public class Libro {
    private int isbn;
    private ArrayList<Autor> autores;
    private Formato formato;
    private double precioNominal;

    public Libro(int isbn, ArrayList<Autor> autores, Formato formato, double precioNominal) {
        this.isbn = isbn;
        this.autores = autores;
        this.formato = formato;
        this.precioNominal = precioNominal;
    }

    public int getIsbn() {
        return isbn;
    }
    public ArrayList<Autor> getAutores() {
        return autores;
    }
    public Formato getFormato() {
        return formato;
    }
    public double getPrecio() {
        if(this.formato instanceof Papel){
            if (this.formato.getTipo().toLowerCase().equals("tapa dura")) {
                return this.precioNominal * 1.20;
            }
            else
                return this.precioNominal;
        }
        else{
          if(this.formato instanceof Digital){
              if(this.formato.getTipo().toLowerCase().equals("mobi")){
                  return this.precioNominal * 0.95;
              }
              else{
                  return this.precioNominal * 0.85;
              }
          }
          else {
              return this.precioNominal;
          }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Libro){
            return ( this.isbn == ((Libro)obj).getIsbn() );
        }
        else
            return false;
    }
}