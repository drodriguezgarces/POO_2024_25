package movilidad;

import java.util.Scanner;

import controller.SistemaController;
import model.Base;

public class Movilidad {
	
    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();
        
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        int opcion_gest = -1;
        
        while(opcion != 0) {
        	System.out.println("\nGestión de movilidad:");
            System.out.println("1. Gestionar usuarios");
            System.out.println("2. Gestionar vahiculos");
            System.out.println("3. Gestionar bases");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
            case 1:
            	// Gestion usuarios
            	System.out.println("\nGestión de usuarios:");
                System.out.println("1. Registrar usuarios");
                System.out.println("2. Eliminar usuarios");
                System.out.println("3. Consultar usuarios");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion_gest = scanner.nextInt();
                
                switch(opcion_gest) {
                case 1:
                	// Registrar usuarios
                	
                	break;
                case 2:
                	// Eliminar usuarios
                	
                	break;
                case 3:
                	// Consultar usuarios
                	
                	break;
                }
            	break;
            case 2:
            	// Gestion vehiculos
            	System.out.println("\nGestión de vehiculos:");
                System.out.println("1. Registrar vahiculos");
                System.out.println("2. Eliminar vahiculos");
                System.out.println("3. Consultar vahiculos");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion_gest = scanner.nextInt();
                
                switch(opcion_gest) {
                case 1:
                	// Agregar vehículos
                	
                	break;
                case 2:
                	// Eliminar vehículos
                	
                	break;
                case 3:
                	// Consultar vehículos
                	
                	break;
                }
            	break;
            case 3:
            	// Gestion bases
            	System.out.println("\nGestión de bases:");
                System.out.println("1. Registrar bases");
                System.out.println("2. Eliminar bases");
                System.out.println("3. Consultar bases");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion_gest = scanner.nextInt();
                
                switch(opcion_gest) {
                case 1:
                	 // Agregar bases
                	
                	break;
                case 2:
                	// Eliminar bases
                	
                	break;
                case 3:
                	// Consultar bases
                	
                	break;
                }
            	break;
            }
        }

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