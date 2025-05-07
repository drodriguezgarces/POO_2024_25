package util;

public class ValidationUtils {
    public static boolean esDniValido(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Z]");
    }
}