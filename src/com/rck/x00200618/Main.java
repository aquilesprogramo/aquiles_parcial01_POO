package com.rck.x00200618;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int op1=0,op2=0,op3=0;
        String nombre="",puesto="",borrar="",empresa="",Nmd="",Numdocum="";
        double salario=0;
        int cantidadmeses=0,extencion=0,id=0;
        empresa=JOptionPane.showInputDialog(null,"Nombre de la empresa:");
        Empresa corp=new Empresa(empresa);
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
                            Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                            Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                            ServicioProfesional servicioProfesional= new ServicioProfesional(nombre,puesto,salario,cantidadmeses);
                            corp.addEmpleado(servicioProfesional);
                            id=1;

                            Documento documento=new Documento(Nmd,Numdocum);
                            servicioProfesional.documentos.add(documento);
                            do {
                                op3=Integer.parseInt(JOptionPane.showInputDialog(null,menu2()));

                                switch (op3){
                                    case 1:
                                        Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                        Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                        Documento documento1=new Documento(Nmd,Numdocum);
                                        servicioProfesional.documentos.add(documento1);
                                        break;

                                }
                            }while(op3!=2);



                            break;
                        case 2:

                            nombre=JOptionPane.showInputDialog(null,"Nombre del emplado:");
                            puesto=JOptionPane.showInputDialog(null,"Puesto que ocupara:");
                            salario=Integer.parseInt(JOptionPane.showInputDialog(null,"Salario:"));
                            extencion=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero telefonico de la oficina:"));
                            PlazaFija plazaFija=new PlazaFija(nombre,puesto,salario,extencion);
                            Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                            Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                            corp.addEmpleado(plazaFija);
                            id=2;
                            Documento documento2=new Documento(Nmd,Numdocum);
                            plazaFija.documentos.add(documento2);
                            do {
                                op3=Integer.parseInt(JOptionPane.showInputDialog(null,menu2()));

                                switch (op3){
                                    case 1:
                                        Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                        Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                        Documento documento3=new Documento(Nmd,Numdocum);
                                        plazaFija.documentos.add(documento3);
                                        break;

                                }
                            }while(op3!=2);
                            break;


                    }
                    break;
                    //no funciona borrar
                case 2:
                    borrar=JOptionPane.showInputDialog(null,"Nombre del empleado a despedir:");
                    corp.removeEmpleado(borrar);

                    break;
                case 3:

                    if (corp.getPlanilla().size()!=0) {
                        corp.getPlanilla().forEach(obj -> {
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

                    //elegir nombre y mostrar sueldo de el
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
    public static String menu2(){
        return "1) Agregar otro documento\n2) No agregar mas";
    }
}
