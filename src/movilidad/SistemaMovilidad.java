package movilidad;

import java.util.ArrayList;

import base.Base;
import trabajadores.Trabajador;
import usuarios.Usuario;
import vehiculos.Vehiculo;

public class SistemaMovilidad {
	 private ArrayList<Usuario> usuarios;
	    private ArrayList<Trabajador> trabajadores;
	    private ArrayList<Vehiculo> vehiculos;
	    private ArrayList<Base> bases;

	    public SistemaMovilidad() {
	        usuarios = new ArrayList<>();
	        trabajadores = new ArrayList<>();
	        vehiculos = new ArrayList<>();
	        bases = new ArrayList<>();
	    }

	    public void registrarUsuario(Usuario u) {
	        usuarios.add(u);
	    }

	    public void agregarVehiculo(Vehiculo v) {
	        vehiculos.add(v);
	    }

	    public void asignarTrabajador(Trabajador t) {
	        trabajadores.add(t);
	    }
}
