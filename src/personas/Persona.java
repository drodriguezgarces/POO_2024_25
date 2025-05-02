package personas;

public abstract class Persona {
	protected String nombre;
    protected String dni;
    protected String email;

    public Persona(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }
	
	public abstract void mostrarInfo();
}
