package model;

public abstract class Persona {
	protected String nombre;
    protected String dni;
    private double saldo;

    public Persona(String nombre, String dni, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = saldo;
    }
	
 // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos comunes
    public void recargarSaldo(double monto) {
        this.saldo += monto;
    }
}
