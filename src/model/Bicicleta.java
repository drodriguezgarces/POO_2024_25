package model;

public class Bicicleta extends Vehiculo {
	
    public Bicicleta(String id, String tipo, double nivelBateria) {
        super(id, tipo, nivelBateria);
    }

    @Override
    public void calcularConsumo(double minutosUso) {
        double consumo = 1.0; // 1% por minuto
        setNivelBateria(getNivelBateria() - (minutosUso * consumo));
    }
}