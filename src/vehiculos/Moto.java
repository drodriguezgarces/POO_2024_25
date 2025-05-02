package vehiculos;

public class Moto extends Vehiculo {
    private double cilindrada;
    private double bateria;

    public Moto(String id, double cilindrada, double bateria) {
        super(id, "Moto");
        this.cilindrada = cilindrada;
        this.bateria = bateria;
    }

    public void recargarBateria() {
        bateria = 100;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Moto ID: " + id + ", Batería: " + bateria + "%");
    }
}
