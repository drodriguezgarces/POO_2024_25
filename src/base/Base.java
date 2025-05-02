package base;

import java.util.ArrayList;

import vehiculos.Vehiculo;

public class Base {
	 private String nombre;
	    private int capacidad;
	    private int ocupacion;
	    private double[] coordenadas;
	    private ArrayList<Vehiculo> vehiculos;

	    public Base(String nombre, int capacidad, double[] coordenadas) {
	        this.nombre = nombre;
	        this.capacidad = capacidad;
	        this.coordenadas = coordenadas;
	        this.vehiculos = new ArrayList<>();
	        this.ocupacion = 0;
	    }

	    public void agregarVehiculo(Vehiculo v) {
	        if (ocupacion < capacidad) {
	            vehiculos.add(v);
	            ocupacion++;
	        }
	    }

	    public void retirarVehiculo(Vehiculo v) {
	        if (vehiculos.remove(v)) {
	            ocupacion--;
	        }
	    }
}
