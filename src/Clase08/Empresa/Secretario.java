package Clase08.Empresa;

import java.time.LocalDate;

public class Secretario extends Empleado{
    private String despacho,numeroFax;

    public Secretario(String apenom, String direccion, long dni, long telefono, double salario, LocalDate fechaIngreso, String despacho, String fax){
        super(apenom, direccion, dni, telefono, salario, fechaIngreso);
        this.despacho = despacho;
        this.numeroFax = fax;
    }

}
