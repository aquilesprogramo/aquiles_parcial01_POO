package com.rck.x00200618;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<Empleado>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado agregar)
    {
        planilla.add(agregar);
    }

    public void removeEmpleado(String borrar){
        planilla.forEach(empl->{
            if (empl.getNombre()==borrar){
                planilla.remove(empl);
            }
        });
    }

}
