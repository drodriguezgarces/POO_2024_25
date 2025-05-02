package vehiculos;

public class Patinete extends Vehiculo {
    private double autonomia;

    public Patinete(String id, double autonomia) {
        super(id, "Patinete");
        this.autonomia = autonomia;
    }

    public void verificarBateria() {
        // implementación
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Patinete ID: " + id + ", Autonomía: " + autonomia + " km");
    }
}
