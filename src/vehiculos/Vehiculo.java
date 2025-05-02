package vehiculos;

public abstract class Vehiculo {
	protected String id;
    protected String tipo;
    protected boolean disponible;

    public Vehiculo(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = true;
    }

    public abstract void mostrarEstado();
}
