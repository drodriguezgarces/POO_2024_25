package model;

public class Trabajador extends Persona {
	private String tipo;

    public Trabajador(String nombre, String dni, double saldo, String tipo) {
        super(nombre, dni, saldo);
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
