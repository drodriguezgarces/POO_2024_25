package trabajadores;

import personas.Persona;
import usuarios.Usuario;

public class Trabajador extends Persona {
    private String puesto; // mecánico, mantenimiento, administrador

    public Trabajador(String nombre, String dni, String email, String puesto) {
        super(nombre, dni, email);
        this.puesto = puesto;
    }

    public void realizarTarea(String tarea) {
        // implementación
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Trabajador: " + nombre + ", Puesto: " + puesto);
    }
}
