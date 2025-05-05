package model;

import java.util.List;

public class Administrador extends Trabajador {
    public Administrador(String nombre, String dni, double saldo) {
        super(nombre, dni, saldo, "Administrador");
    }

    // Métodos específicos del administrador
    public void gestionarUsuarios(List<Persona> personas) {
        // Lógica para altas, bajas y modificaciones de usuarios
    }

    public void promocionarUsuariosPremium(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            // Verificar las condiciones para promoción a Premium
            if (cumpleCondicionesPremium(usuario)) {
                usuario.setEsPremium(true);
                System.out.println("Usuario " + usuario.getNombre() + " ha sido promocionado a Premium.");
            }
        }
    }

    private boolean cumpleCondicionesPremium(Usuario usuario) {
        // Obtenemos el historial de viajes del usuario
        List<Viaje> historialViajes = usuario.getHistorialViajes();

        // Condición 1: Ha utilizado algún vehículo al menos 15 veces en el último mes
        long viajesUltimoMes = historialViajes.stream()
                .filter(viaje -> viaje.getInicio().isAfter(java.time.LocalDateTime.now().minusMonths(1)))
                .count();
        if (viajesUltimoMes >= 15) {
            return true;
        }

        // Condición 2: Ha utilizado algún vehículo al menos 10 veces al mes durante 3 meses consecutivos
        long viajesMesActual = historialViajes.stream()
        	    .filter(viaje -> viaje.getInicio().toLocalDate().getMonthValue() == java.time.LocalDate.now().getMonthValue())
        	    .count();
        long viajesMesAnterior = historialViajes.stream()
                .filter(viaje -> viaje.getInicio().getMonthValue() == java.time.LocalDate.now().minusMonths(1).getMonthValue())
                .count();
        long viajesDosMesesAtras = historialViajes.stream()
                .filter(viaje -> viaje.getInicio().getMonthValue() == java.time.LocalDate.now().minusMonths(2).getMonthValue())
                .count();

        if (viajesMesActual >= 10 && viajesMesAnterior >= 10 && viajesDosMesesAtras >= 10) {
            return true;
        }

        // Condición 3: Ha utilizado los tres tipos de vehículos al menos una vez cada uno durante 6 meses consecutivos
        boolean haUsadoMoto = historialViajes.stream()
                .filter(viaje -> viaje.getVehiculo() instanceof Moto)
                .anyMatch(viaje -> viaje.getInicio().isAfter(java.time.LocalDateTime.now().minusMonths(6)));
        boolean haUsadoBicicleta = historialViajes.stream()
                .filter(viaje -> viaje.getVehiculo() instanceof Bicicleta)
                .anyMatch(viaje -> viaje.getInicio().isAfter(java.time.LocalDateTime.now().minusMonths(6)));
        boolean haUsadoPatinete = historialViajes.stream()
                .filter(viaje -> viaje.getVehiculo() instanceof Patinete)
                .anyMatch(viaje -> viaje.getInicio().isAfter(java.time.LocalDateTime.now().minusMonths(6)));

        if (haUsadoMoto && haUsadoBicicleta && haUsadoPatinete) {
            return true;
        }

        // Si no cumple ninguna condición, no es promocionable a Premium
        return false;
    }

    public void asignarTareasMantenimiento(List<Vehiculo> vehiculos, EncargadoMantenimiento encargado) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNivelBateria() < 20) {
                // Asignar vehículo al encargado
                encargado.recogerVehiculo(vehiculo);
            }
        }
    }
}