package Clase08.Empresa;

import java.time.LocalDate;

public class Vendedor extends Empleado{
    private long telefonoMovil;
    private Coche cocheEmpresa;

    public Vendedor(String apenom, String direccion, long dni, long telefono, double salario, LocalDate fechaIngreso, long movil, Coche coche) {
        super(apenom, direccion, dni, telefono, salario, fechaIngreso);
        this.telefonoMovil = movil;
        this.cocheEmpresa = coche;
    }
}
