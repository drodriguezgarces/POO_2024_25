package movilidad;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.SistemaController;
import model.Base;
import model.Vehiculo;

public class Movilidad {

	public static void main(String[] args) {
		SistemaController sistema = new SistemaController();

		Scanner scanner = new Scanner(System.in);
		int opcion = -1;
		int opcion_gest = -1;
		boolean ok;
		
		while (opcion != 0) {
			
			System.out.println("\nGestión de movilidad:");
			System.out.println("1. Gestionar usuarios");
			System.out.println("2. Gestionar vahiculos");
			System.out.println("3. Gestionar bases");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				String nombre;
				String dni;
				double saldo = 0.0;
				String strPremium;
				boolean premium = false;
				
				// Gestion usuarios
				System.out.println("\nGestión de usuarios:");
				System.out.println("1. Registrar usuarios");
				System.out.println("2. Eliminar usuarios");
				System.out.println("3. Consultar usuario");
				System.out.println("0. Salir");
				System.out.print("Seleccione una opción: ");
				opcion_gest = scanner.nextInt();

				switch (opcion_gest) {
				case 1:
					// Registrar usuarios
					System.out.println("\nRegistro de usuario:");
					do {
						ok = true;
						
						System.out.println("Nombre de usuario:");
						nombre = scanner.next();
						System.out.println("DNI de usuario:");
						dni = scanner.next();
						System.out.println("Saldo de usuario:");
						saldo = scanner.nextDouble();
						System.out.println("Es Premium(s/n):");
						strPremium = scanner.next();
						
						if (strPremium == "s" || strPremium == "y") {
							premium = true;
						} else {
							premium = false;
						}
						if (nombre == null || dni == null) {
							ok = false;
							System.err.println("Nombre o dni vacio");
						}
					} while (!ok);
					sistema.registrarUsuario(nombre, dni, saldo, premium);
					break;
					
				case 2:
					// Eliminar usuarios
					System.out.println("\nEliminar usuario");
					do {
						ok = true;
						
						System.out.println("Dni del usuario:");
						dni = scanner.next();
						
						if(dni == null) {
							ok = false;
							System.err.println("DNI vacio");
						}
					}while(!ok);
					sistema.eliminarUsuario(dni);
					break;

				case 3:
					// Consultar usuario
					System.out.println("\nConsulta de usuario");
					
					break;
				}
				break;
			case 2:
				String id_vehiculo;
				String tipo_vehiculo;
				double bateria;
				String strGrande;
				boolean grande;
				
				// Gestion vehiculos
				System.out.println("\nGestión de vehiculos:");
				System.out.println("1. Registrar vahiculos");
				System.out.println("2. Eliminar vahiculos");
				System.out.println("3. Consultar vahiculos");
				System.out.println("0. Salir");
				System.out.print("Seleccione una opción: ");
				opcion_gest = scanner.nextInt();

				switch (opcion_gest) {
				case 1:
					// Agregar vehículos
					System.out.println("\nRegistrar vehiculo");
					do {
						ok = true;
						
						System.out.println("Id del vehiculo:");
						id_vehiculo = scanner.next();
						System.out.println("Tipo de vehiculo(moto/patinete/bicicleta):");
						tipo_vehiculo = scanner.next();
						System.out.println("Porcentaje bateria:");
						bateria = scanner.nextDouble();
						System.out.println("Es grande(s/n):");
						strGrande = scanner.next();
						if (strGrande == "s" || strGrande == "y") {
							grande = true;
						} else {
							grande = false;
						}
						
						if(id_vehiculo == null || tipo_vehiculo == null) {
							ok = false;
							System.err.println("Id o tipo de vehiculo vacio");
						}
					}while(!ok);
					sistema.agregarVehiculo(id_vehiculo.toUpperCase(), tipo_vehiculo, bateria, grande);
					break;
				case 2:
					// Eliminar vehículos
					System.out.println("\nEliminar vehiculo");
					do {
						ok = true;
						
						System.out.println("Dni del usuario:");
						id_vehiculo = scanner.next();
						
						if(id_vehiculo == null) {
							ok = false;
							System.err.println("Id vacio");
						}
					}while(!ok);
					sistema.eliminarVehiculo(id_vehiculo);
					break;
				case 3:
					// Consultar vehículos
					System.out.println("\nListado vehiculos");
					List<Vehiculo> vehiculos = sistema.listarVehiculosDisponibles();
					for (Vehiculo vehiculo : vehiculos) {
						System.out.println("Id: " + vehiculo.getId());
						System.out.println("Tipo: " + vehiculo.getTipo());
						System.out.println("Bateria: " + vehiculo.getNivelBateria());
						System.out.println("---------------------------------------");
					}
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

				switch (opcion_gest) {
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

		// Agregar bases
		sistema.agregarBase("Base Norte", 10, new int[] { 0, 0 });
		sistema.agregarBase("Base Sur", 15, new int[] { 10, 5 });

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