package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    // Altas de usuarios
    public void registrarUsuario(Usuario usuario) {
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
            if (/* lógica personalizada */ false) {
                usuario.setEsPremium(true);
                System.out.println("Usuario " + usuario.getNombre() + " ha sido promocionado a Premium.");
            }
        }
    }
}