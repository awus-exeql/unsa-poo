package Clase08.Empresa;

import java.time.LocalDate;

public class Pasante extends Empleado{

    public Pasante(String apenom, String direccion, long dni, long telefono, double salario, LocalDate fechaIngreso) {
        super(apenom, direccion, dni, telefono, salario, fechaIngreso);
    }
    public boolean esContratoVigente() {
        LocalDate fechaVencimiento = getFechaIngreso().plusDays(90);
        return LocalDate.now().isBefore(fechaVencimiento);
    }
}
