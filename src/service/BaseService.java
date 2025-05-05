package service;

import model.Base;

import java.util.ArrayList;
import java.util.List;

public class BaseService {
    private List<Base> bases;

    public BaseService() {
        this.bases = new ArrayList<>();
    }

    // Agregar base
    public void agregarBase(Base base) {
        bases.add(base);
        System.out.println("Base agregada: " + base.getNombre());
    }

    // Eliminar base
    public void eliminarBase(String nombre) {
        bases.removeIf(base -> base.getNombre().equals(nombre));
        System.out.println("Base " + nombre + " eliminada.");
    }

    // Consultar base por nombre
    public Base buscarBasePorNombre(String nombre) {
        for (Base base : bases) {
            if (base.getNombre().equals(nombre)) {
                return base;
            }
        }
        System.out.println("Base " + nombre + " no encontrada.");
        return null;
    }

    // Consultar ocupación de todas las bases
    public void mostrarOcupacionBases() {
        for (Base base : bases) {
            System.out.println("Base: " + base.getNombre() + " | Ocupación: " + base.getOcupacion() + "/" + base.getCapacidad());
        }
    }
}