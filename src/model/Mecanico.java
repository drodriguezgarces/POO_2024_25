package model;

public class Mecanico extends Trabajador {
    public Mecanico(String nombre, String dni, double saldo) {
        super(nombre, dni, saldo, "Mecánico");
    }

    // Métodos específicos
    public void repararVehiculo(Vehiculo vehiculo) {
        System.out.println("Reparando el vehículo: " + vehiculo.getId());
        vehiculo.setDisponible(true);
    }

    public void repararBase(Base base) {
        System.out.println("Reparando la base: " + base.getNombre());
        base.setOcupacion(0); // Ejemplo: vaciar la base para la reparación
    }
}