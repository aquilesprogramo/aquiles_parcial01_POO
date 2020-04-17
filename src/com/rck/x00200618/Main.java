package com.rck.x00200618;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int op1=0,op2=0;
        String nombre="",puesto="",borrar="";
        double salario=0;
        int cantidadmeses=0,extencion=0;
        do {
            op1=Integer.parseInt(JOptionPane.showInputDialog(null,menu()));
            switch (op1){
                case 1:
                    op2=Integer.parseInt(JOptionPane.showInputDialog(null,"Como desea agregar al empleado\n1) Servicio profesional\n2) Plaza fija"));
                    switch (op2){
                        case 1:
                            nombre=JOptionPane.showInputDialog(null,"Nombre del emplado:");
                            puesto=JOptionPane.showInputDialog(null,"Puesto que ocupara:");
                            salario=Integer.parseInt(JOptionPane.showInputDialog(null,"Salario:"));
                            cantidadmeses=Integer.parseInt(JOptionPane.showInputDialog(null,"Meses estipulados en el contrato:"));
                            ServicioProfesional servicioProfesional= new ServicioProfesional(nombre,puesto,salario,cantidadmeses);
                            break;
                        case 2:
                            nombre=JOptionPane.showInputDialog(null,"Nombre del emplado:");
                            puesto=JOptionPane.showInputDialog(null,"Puesto que ocupara:");
                            salario=Integer.parseInt(JOptionPane.showInputDialog(null,"Salario:"));
                            extencion=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero telefonico de la oficina:"));
                            PlazaFija plazaFija=new PlazaFija(nombre,puesto,salario,extencion);
                            break;
                    }
                    break;
                case 2:
                    borrar=JOptionPane.showInputDialog(null,"Nombre del empleado a despedir:");

                    break;
                case 3:
                    break;
                case 4:JOptionPane.showMessageDialog(null,"Sueldo: "+CalculadoraImpuestos.calcularPago());
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
