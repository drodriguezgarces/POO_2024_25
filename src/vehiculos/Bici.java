package vehiculos;

public class Bici extends Vehiculo {
    private boolean electrica;

    public Bici(String id, boolean electrica) {
        super(id, "Bicicleta");
        this.electrica = electrica;
    }

    public void reparar() {
        // implementación
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Bicicleta ID: " + id + ", Eléctrica: " + electrica);
    }

}
