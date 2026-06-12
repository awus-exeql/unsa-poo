package interfaces.LineaDeTransporte;

public interface IElectrico {
    double ALTO_VOLTAJE = 600;
    double BAJO_VOLTAJE = 480;
    double getVoltaje();
}
