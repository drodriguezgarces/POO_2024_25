package util;

public class Constants {
    // Tarifas para los usuarios
    public static final double TARIFA_PREMIUM = 0.5; // Tarifa por minuto para usuarios Premium
    public static final double TARIFA_REGULAR = 1.0; // Tarifa por minuto para usuarios regulares

    // Batería mínima requerida para iniciar un viaje
    public static final double BATERIA_MINIMA = 20.0; // En porcentaje

    // Límites y condiciones
    public static final int VIAJES_ULTIMO_MES = 15; // Número de viajes para promoción Premium
    public static final int VIAJES_POR_MES = 10; // Número de viajes por mes durante 3 meses consecutivos
    public static final int MESES_VEHICULO_USO = 6; // Meses para verificar uso de diferentes vehículos

    // Mensajes comunes
    public static final String ERROR_SALDO_INSUFICIENTE = "El usuario no tiene saldo suficiente.";
    public static final String ERROR_BATERIA_INSUFICIENTE = "El vehículo no tiene suficiente batería.";
}