package service;

import model.Usuario;
import model.Viaje;
import util.ValidationUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
	
    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    // Altas de usuarios
    public void registrarUsuario(Usuario usuario) {
    	if (!ValidationUtils.esDniValido(usuario.getDni())) {
    	    System.out.println("El DNI ingresado no es válido.");
    	    return;
    	}
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    // Baja de usuarios
    public void eliminarUsuario(String dni) {
        usuarios.removeIf(usuario -> usuario.getDni().equals(dni));
        System.out.println("Usuario con DNI " + dni + " eliminado.");
    }

    // Consultar usuarios
    public Usuario buscarUsuarioPorDni(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        System.out.println("Usuario con DNI " + dni + " no encontrado.");
        return null;
    }

    // Promocionar a premium
    public void promocionarUsuariosPremium() {
        for (Usuario usuario : usuarios) {
            // Aquí implementaremos la lógica para promocionar según las condiciones
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

        // Condición 3: Ha utilizado los tres tipos de vehículos al menos una vez cada uno durante los últimos 6 meses
        boolean haUsadoMoto = haUtilizadoVehiculoDeTipo(historialViajes, "Moto", 6);
        boolean haUsadoBicicleta = haUtilizadoVehiculoDeTipo(historialViajes, "Bicicleta", 6);
        boolean haUsadoPatinete = haUtilizadoVehiculoDeTipo(historialViajes, "Patinete", 6);
        if (haUsadoMoto && haUsadoBicicleta && haUsadoPatinete) {
            return true;
        }

        // Si no cumple ninguna condición, no es promocionable a Premium
        return false;
    }

    // Método para contar viajes en un mes específico
    private long contarViajesEnMes(List<Viaje> viajes, int mes) {
        return viajes.stream()
                .filter(viaje -> viaje.getInicio().toLocalDate().getMonthValue() == mes)
                .count();
    }

    // Método para verificar si un usuario ha utilizado un tipo de vehículo en los últimos N meses
    private boolean haUtilizadoVehiculoDeTipo(List<Viaje> viajes, String tipo, int meses) {
        return viajes.stream()
                .filter(viaje -> viaje.getVehiculo().getTipo().equalsIgnoreCase(tipo))
                .anyMatch(viaje -> viaje.getInicio().toLocalDate().isAfter(LocalDate.now().minusMonths(meses)));
    }
}