package model;

public class Moto extends Vehiculo {
	
    private boolean esGrande;

    public Moto(String id, String tipo, double nivelBateria, boolean esGrande) {
        super(id, tipo, nivelBateria);
        this.esGrande = esGrande;
    }

    public boolean isEsGrande() {
        return esGrande;
    }

    public void setEsGrande(boolean esGrande) {
        this.esGrande = esGrande;
    }

    @Override
    public void calcularConsumo(double minutosUso) {
        double consumo = esGrande ? 0.25 : 0.4;
        setNivelBateria(getNivelBateria() - (minutosUso * consumo));
    }
}