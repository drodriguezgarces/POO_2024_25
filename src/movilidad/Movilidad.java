package movilidad;

import controller.SistemaController;
import model.Base;

public class Movilidad {
	
    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();

     // Registrar usuarios
        sistema.registrarUsuario("Alice", "12345678A", 50.0, false);
        sistema.registrarUsuario("Bob", "87654321B", 30.0, true);

        // Agregar vehículos
        sistema.agregarVehiculo("MOTO001", "Moto", 100.0, true);
        sistema.agregarVehiculo("BICI001", "Bicicleta", 100.0, false);

        // Agregar bases
        sistema.agregarBase("Base Norte", 10, new int[]{0, 0});
        sistema.agregarBase("Base Sur", 15, new int[]{10, 5});

        // Mostrar ocupación de todas las bases
        sistema.mostrarOcupacionBases();

        // Buscar una base por su nombre
        Base baseEncontrada = sistema.buscarBasePorNombre("Base Norte");
        if (baseEncontrada != null) {
            System.out.println("Base encontrada: " + baseEncontrada.getNombre());
        } else {
            System.out.println("Base no encontrada.");
        }

        // Eliminar una base
        sistema.eliminarBase("Base Sur");

        // Mostrar ocupación nuevamente
        sistema.mostrarOcupacionBases();
    }
}