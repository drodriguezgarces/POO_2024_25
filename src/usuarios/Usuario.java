package usuarios;

import personas.Persona;
import vehiculos.Vehiculo;

public class Usuario extends Persona {
	 private String tipoUsuario; // "estándar" o "premium"
	    private double saldo;

	    public Usuario(String nombre, String dni, String email, String tipoUsuario, double saldo) {
	        super(nombre, dni, email);
	        this.tipoUsuario = tipoUsuario;
	        this.saldo = saldo;
	    }

	    public void alquilarVehiculo(Vehiculo v) {
	        // implementación
	    }

	    public void devolverVehiculo(Vehiculo v) {
	        // implementación
	    }

	    public void recargarSaldo(double cantidad) {
	        saldo += cantidad;
	    }

	    public void mostrarInfo() {
	        System.out.println("Usuario: " + nombre + ", Tipo: " + tipoUsuario + ", Saldo: " + saldo);
	    }
}
