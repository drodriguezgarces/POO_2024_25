package model;

public class Patinete extends Vehiculo {
    public Patinete(String id, String tipo, double nivelBateria) {
        super(id, tipo, nivelBateria);
    }

    @Override
    public void calcularConsumo(double minutosUso) {
        double consumo = 0.5; // 0.5% por minuto
        setNivelBateria(getNivelBateria() - (minutosUso * consumo));
    }
}