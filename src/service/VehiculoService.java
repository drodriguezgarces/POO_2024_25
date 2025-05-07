package service;

import model.Base;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
	
    private List<Vehiculo> vehiculos;

    public VehiculoService() {
        this.vehiculos = new ArrayList<>();
    }

    // Agregar un vehículo
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado: " + vehiculo.getId());
    }

    // Eliminar un vehículo
    public void eliminarVehiculo(String id) {
        vehiculos.removeIf(vehiculo -> vehiculo.getId().equals(id));
        System.out.println("Vehículo con ID " + id + " eliminado.");
    }

    // Consultar vehículos disponibles
    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    // Asignar vehículo a una base
    public void asignarVehiculoABase(Vehiculo vehiculo, Base base) {
        if (base.hayEspacioDisponible()) {
            vehiculo.setDisponible(false);
            base.setOcupacion(base.getOcupacion() + 1);
            System.out.println("Vehículo " + vehiculo.getId() + " asignado a la base " + base.getNombre());
        } else {
            System.out.println("La base " + base.getNombre() + " está llena.");
        }
    }
}