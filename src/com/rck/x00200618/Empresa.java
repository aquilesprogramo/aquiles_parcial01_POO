package com.rck.x00200618;

import javax.swing.*;
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
        if (planilla.size()!=0) {
            planilla.forEach(empl -> {
                if (empl.getNombre() == borrar) {
                    planilla.remove(empl);
                }
            });
        }
        else{
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
        }
    }

}
