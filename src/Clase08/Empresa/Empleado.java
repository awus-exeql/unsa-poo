package Clase08.Empresa;
import java.time.LocalDate;
import java.time.Period;
public abstract class Empleado {
    private String apenom, direccion;
    private long dni,telefono;
    private double salario;
    private LocalDate fechaIngreso;
    private Empleado supervisor;

    public Empleado(String apenom, String direccion, long dni, long telefono, double salario, LocalDate fechaIngreso){
        this.apenom = apenom;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }
    public Empleado(){
        apenom = direccion = "";
        salario = dni = telefono = 0;
    }
    public int calcularAntiguedad() {
        return Period.between(this.fechaIngreso, LocalDate.now()).getYears();
    }

    public String getApenom() {
        return apenom;
    }

    public void setApenom(String apenom) {
        this.apenom = apenom;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Empleado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }

}
