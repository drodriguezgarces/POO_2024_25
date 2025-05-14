package service;

import model.Usuario;
import model.Vehiculo;
import model.Viaje;
import util.Constants;
import util.ValidationUtils;

import java.time.LocalDateTime;

public class ViajeService {
	
    public Viaje iniciarViaje(String id, Usuario usuario, Vehiculo vehiculo) {
    	if (!ValidationUtils.tieneBateriaSuficiente(vehiculo.getNivelBateria())) {
    	    System.out.println(Constants.ERROR_BATERIA_INSUFICIENTE);
    	    return null;
    	}
    	
        if (usuario.getSaldo() <= 0) {
            System.out.println(Constants.ERROR_SALDO_INSUFICIENTE);
            return null;
        }

        if (!vehiculo.isDisponible()) {
            System.out.println("El vehículo no está disponible.");
            return null;
        }

        vehiculo.setDisponible(false);
        Viaje viaje = new Viaje(id, usuario, vehiculo, LocalDateTime.now());
        System.out.println("Viaje iniciado con el vehículo: " + vehiculo.getId());
        return viaje;
    }

    public void finalizarViaje(Viaje viaje, LocalDateTime fin, double tarifaPorMinuto) {
        viaje.finalizarViaje(fin, tarifaPorMinuto);
        viaje.getVehiculo().setDisponible(true);
        System.out.println("Viaje finalizado. Costo: " + viaje.getCosto());
    }
}