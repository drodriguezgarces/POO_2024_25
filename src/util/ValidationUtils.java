package util;

import model.Usuario;

public class ValidationUtils {
    // Validar un DNI (8 dígitos seguidos de una letra mayúscula)
    public static boolean esDniValido(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Z]");
    }

    // Validar que un usuario tiene saldo suficiente
    public static boolean tieneSaldoSuficiente(Usuario usuario, double costo) {
        if (usuario == null) return false;
        return usuario.getSaldo() >= costo;
    }

    // Validar que un vehículo tiene suficiente batería
    public static boolean tieneBateriaSuficiente(double nivelBateria) {
        return nivelBateria >= Constants.BATERIA_MINIMA;
    }

    // Validar que una cadena no esté vacía o nula
    public static boolean esCadenaValida(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }
}