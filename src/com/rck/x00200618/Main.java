package com.rck.x00200618;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int op1=0,op2=0;
        String nombre="",puesto="",borrar="",empresa="";
        double salario=0;
        int cantidadmeses=0,extencion=0,id=0;
        do {
            op1=Integer.parseInt(JOptionPane.showInputDialog(null,menu()));
            switch (op1){
                case 1:
                    op2=Integer.parseInt(JOptionPane.showInputDialog(null,"Como desea agregar al empleado\n1) Servicio profesional\n2) Plaza fija"));
                    switch (op2){
                        case 1:
                            empresa=JOptionPane.showInputDialog(null,"Nombre de la empresa:");
                            Empresa corp1=new Empresa(empresa);
                            nombre=JOptionPane.showInputDialog(null,"Nombre del emplado:");
                            puesto=JOptionPane.showInputDialog(null,"Puesto que ocupara:");
                            salario=Integer.parseInt(JOptionPane.showInputDialog(null,"Salario:"));
                            cantidadmeses=Integer.parseInt(JOptionPane.showInputDialog(null,"Meses estipulados en el contrato:"));
                            ServicioProfesional servicioProfesional= new ServicioProfesional(nombre,puesto,salario,cantidadmeses);
                            corp1.addEmpleado(servicioProfesional);
                            id=1;
                            break;
                        case 2:
                            empresa=JOptionPane.showInputDialog(null,"Nombre de la empresa:");
                            Empresa corp2=new Empresa(empresa);
                            nombre=JOptionPane.showInputDialog(null,"Nombre del emplado:");
                            puesto=JOptionPane.showInputDialog(null,"Puesto que ocupara:");
                            salario=Integer.parseInt(JOptionPane.showInputDialog(null,"Salario:"));
                            extencion=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero telefonico de la oficina:"));
                            PlazaFija plazaFija=new PlazaFija(nombre,puesto,salario,extencion);
                            corp2.addEmpleado(plazaFija);
                            id=2;
                            break;


                    }
                    break;
                case 2:
                    borrar=JOptionPane.showInputDialog(null,"Nombre del empleado a despedir:");
                    Empresa corp=new Empresa(empresa);
                    corp.removeEmpleado(borrar);

                    break;
                case 3:
                    System.out.println(nombre);
                    Empresa corp3=new Empresa(empresa);
                    if (corp3.getPlanilla().size()!=0) {
                        corp3.getPlanilla().forEach(obj -> {
                            if (obj instanceof ServicioProfesional) {
                                JOptionPane.showMessageDialog(null, obj.toString());
                            }
                            else if (obj instanceof PlazaFija) {
                                JOptionPane.showMessageDialog(null, obj.toString());
                            }
                        });

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"La lista esta vacia");
                    }
                    break;
                case 4:
                    ServicioProfesional servicioProfesional= new ServicioProfesional(nombre,puesto,salario,cantidadmeses);
                    PlazaFija plazaFija=new PlazaFija(nombre,puesto,salario,extencion);

                    if (id==1){
                    JOptionPane.showMessageDialog(null,"Sueldo: "+CalculadoraImpuestos.calcularPago(servicioProfesional)+"$");}
                    else{
                        JOptionPane.showMessageDialog(null,"Sueldo: "+CalculadoraImpuestos.calcularPago(plazaFija)+"$");
                    }
                    break;
                case 5:
                    break;
            }
        }while (op1!=6);
    }
    public static String menu(){
        return "1) Agregar empleado\n2) Despedir empleado\n3) Ver lista de empleados\n4) Calcular sueldo\n5) Mostrar totales\n6) Salir\nSu opcion:";
    }
}
