package movilidad;

import controller.SistemaController;

public class Movilidad {
	
    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();

        // Registrar usuarios
        sistema.registrarUsuario("Alice", "12345678A", 50.0, false);
        sistema.registrarUsuario("Bob", "87654321B", 30.0, true);

        // Agregar vehículos
        sistema.agregarVehiculo("MOTO001", "Moto", 100.0, true);
        sistema.agregarVehiculo("BICI001", "Bicicleta", 100.0, false);

        // Iniciar y finalizar un viaje
        sistema.iniciarViaje("12345678A", "BICI001");
        sistema.finalizarViaje("12345678A", "BICI001");
    }
}