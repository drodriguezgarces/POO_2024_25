package model;

import java.time.LocalDate;
import java.util.List;

public class Administrador extends Trabajador {
	
    public Administrador(String nombre, String dni, double saldo) {
        super(nombre, dni, saldo, "Administrador");
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
                .filter(viaje -> viaje.getInicio().toLocalDate().isAfter(LocalDate.now().minusMonths(1)))
                .count();
        if (viajesUltimoMes >= 15) {
            return true;
        }

        // Condición 2: Ha utilizado algún vehículo al menos 10 veces al mes durante 3 meses consecutivos
        long viajesMesActual = contarViajesEnMes(historialViajes, LocalDate.now().getMonthValue());
        long viajesMesAnterior = contarViajesEnMes(historialViajes, LocalDate.now().minusMonths(1).getMonthValue());
        long viajesDosMesesAtras = contarViajesEnMes(historialViajes, LocalDate.now().minusMonths(2).getMonthValue());
        if (viajesMesActual >= 10 && viajesMesAnterior >= 10 && viajesDosMesesAtras >= 10) {
            return true;
        }

        // Condición 3: Ha utilizado los tres tipos de vehículos al menos una vez cada uno durante 6 meses consecutivos
        boolean haUsadoMoto = haUtilizadoVehiculoDeTipo(historialViajes, "Moto", 6);
        boolean haUsadoBicicleta = haUtilizadoVehiculoDeTipo(historialViajes, "Bicicleta", 6);
        boolean haUsadoPatinete = haUtilizadoVehiculoDeTipo(historialViajes, "Patinete", 6);
        if (haUsadoMoto && haUsadoBicicleta && haUsadoPatinete) {
            return true;
        }

        // Si no cumple ninguna condición, no es promocionable a Premium
        return false;
    }

    private long contarViajesEnMes(List<Viaje> viajes, int mes) {
        return viajes.stream()
                .filter(viaje -> viaje.getInicio().toLocalDate().getMonthValue() == mes)
                .count();
    }

    private boolean haUtilizadoVehiculoDeTipo(List<Viaje> viajes, String tipo, int meses) {
        return viajes.stream()
                .filter(viaje -> viaje.getVehiculo().getTipo().equalsIgnoreCase(tipo))
                .anyMatch(viaje -> viaje.getInicio().toLocalDate().isAfter(LocalDate.now().minusMonths(meses)));
    }
}