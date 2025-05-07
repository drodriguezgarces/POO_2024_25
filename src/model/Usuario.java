package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
	
    private boolean esPremium;
    private List<Viaje> historialViajes;

    public Usuario(String nombre, String dni, double saldo, boolean esPremium) {
        super(nombre, dni, saldo);
        this.esPremium = esPremium;
        this.historialViajes = new ArrayList<>();
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public List<Viaje> getHistorialViajes() {
        return historialViajes;
    }

    public void agregarViaje(Viaje viaje) {
        historialViajes.add(viaje);
    }

    public void reservarVehiculo() {
        if (esPremium) {
            System.out.println("Vehículo reservado por 20 minutos.");
        } else {
            System.out.println("Solo los usuarios premium pueden reservar vehículos.");
        }
    }
}