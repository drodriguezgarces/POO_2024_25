package model;

import java.time.LocalDateTime;

public class Viaje {
    private String id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private double costo;

    public Viaje(String id, Usuario usuario, Vehiculo vehiculo, LocalDateTime inicio) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.inicio = inicio;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    // Métodos adicionales
    public void finalizarViaje(LocalDateTime fin, double tarifaPorMinuto) {
        this.fin = fin;

        // Calcular la duración en minutos
        long minutos = java.time.Duration.between(inicio, fin).toMinutes();

        // Calcular el costo total
        this.costo = minutos * tarifaPorMinuto;

        // Actualizar el saldo del usuario
        usuario.setSaldo(usuario.getSaldo() - this.costo);

        // Actualizar la batería del vehículo
        vehiculo.calcularConsumo(minutos);
    }
}