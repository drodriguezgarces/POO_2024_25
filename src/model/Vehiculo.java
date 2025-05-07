package model;

public abstract class Vehiculo {
	
    private String id;
    private String tipo;
    private double nivelBateria;
    private boolean disponible;

    public Vehiculo(String id, String tipo, double nivelBateria) {
        this.id = id;
        this.tipo = tipo;
        this.nivelBateria = nivelBateria;
        this.disponible = true;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(double nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Métodos abstractos
    public abstract void calcularConsumo(double minutosUso);
}