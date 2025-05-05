package service;

import model.Usuario;
import model.Vehiculo;
import model.Viaje;

import java.time.LocalDateTime;

public class ViajeService {
    public Viaje iniciarViaje(String id, Usuario usuario, Vehiculo vehiculo) {
        if (usuario.getSaldo() <= 0) {
            System.out.println("El usuario no tiene saldo suficiente para iniciar un viaje.");
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