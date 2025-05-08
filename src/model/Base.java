package model;

public class Base {
	
    private String nombre;
    private int[] coordenadas;
    private int capacidad;
    private int ocupacion;

    public Base(String nombre, int capacidad, int[] coordenadas) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.capacidad = capacidad;
        this.ocupacion = 0;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }
    
    public void setCoordenadas(int[] coordenadas) {
    	this.coordenadas = coordenadas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }

    // Métodos adicionales
    public boolean hayEspacioDisponible() {
        return ocupacion < capacidad;
    }
}