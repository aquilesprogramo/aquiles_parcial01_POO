package com.rck.x00200618;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    //talvez borrar Arraylist de arriba
    public Empleado(String nombre, String puesto,double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        documentos = new ArrayList<Documento>();
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addDocumento(Documento x)
    {
        documentos.add(x);
    }

    //acabar cuando este el documento
    public void removeDocumento(String borrar)
    {
        documentos.forEach(docum->{
            if(docum.getNombre()==borrar){
                documentos.remove(docum);
            }
        });
    }

}
