package controller;

import model.*;
import service.*;

import java.time.LocalDateTime;

public class SistemaController {
    private UsuarioService usuarioService;
    private VehiculoService vehiculoService;
    private BaseService baseService;
    private ViajeService viajeService;

    public SistemaController() {
        this.usuarioService = new UsuarioService();
        this.vehiculoService = new VehiculoService();
        this.baseService = new BaseService();
        this.viajeService = new ViajeService();
    }

    public void registrarUsuario(String nombre, String dni, double saldo, boolean esPremium) {
        Usuario usuario = new Usuario(nombre, dni, saldo, esPremium);
        usuarioService.registrarUsuario(usuario);
    }

    public void agregarVehiculo(String id, String tipo, double nivelBateria, boolean esGrande) {
        Vehiculo vehiculo;
        if (tipo.equalsIgnoreCase("Moto")) {
            vehiculo = new Moto(id, tipo, nivelBateria, esGrande);
        } else if (tipo.equalsIgnoreCase("Bicicleta")) {
            vehiculo = new Bicicleta(id, tipo, nivelBateria);
        } else {
            vehiculo = new Patinete(id, tipo, nivelBateria);
        }
        vehiculoService.agregarVehiculo(vehiculo);
    }

    public void iniciarViaje(String usuarioDni, String vehiculoId) {
        Usuario usuario = usuarioService.buscarUsuarioPorDni(usuarioDni);
        Vehiculo vehiculo = vehiculoService.listarVehiculosDisponibles()
                                           .stream()
                                           .filter(v -> v.getId().equals(vehiculoId))
                                           .findFirst()
                                           .orElse(null);

        if (usuario != null && vehiculo != null) {
            Viaje viaje = viajeService.iniciarViaje("VIAJE-" + vehiculoId, usuario, vehiculo);
            usuario.agregarViaje(viaje);
        }
    }

    public void finalizarViaje(String usuarioDni, String vehiculoId) {
        Usuario usuario = usuarioService.buscarUsuarioPorDni(usuarioDni);
        Viaje viaje = usuario.getHistorialViajes()
                             .stream()
                             .filter(v -> v.getVehiculo().getId().equals(vehiculoId) && v.getFin() == null)
                             .findFirst()
                             .orElse(null);

        if (viaje != null) {
            viajeService.finalizarViaje(viaje, LocalDateTime.now(), 0.5); // Ejemplo de tarifa
        }
    }
}