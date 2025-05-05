package model;

public class EncargadoMantenimiento extends Trabajador {
    public EncargadoMantenimiento(String nombre, String dni, double saldo) {
        super(nombre, dni, saldo, "Encargado de Mantenimiento");
    }

    // Métodos específicos
    public void recogerVehiculo(Vehiculo vehiculo) {
        System.out.println("Recogiendo el vehículo: " + vehiculo.getId());
        vehiculo.setDisponible(false);
    }

    public void devolverVehiculo(Vehiculo vehiculo, Base base) {
        System.out.println("Devolviendo el vehículo: " + vehiculo.getId() + " a la base: " + base.getNombre());
        vehiculo.setDisponible(true);
    }
}
