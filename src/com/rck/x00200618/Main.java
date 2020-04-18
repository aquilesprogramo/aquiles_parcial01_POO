package com.rck.x00200618;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int op1=0,op2=0,op3=0;
        String nombre="",puesto="",borrar="",empresa="",Nmd="",Numdocum="",search="";
        double salario=0;
        int cantidadmeses=0,extencion=0;
        empresa=JOptionPane.showInputDialog(null,"Nombre de la empresa:");
        Empresa corp=new Empresa(empresa);
        do {

            try {
                op1=Integer.parseInt(JOptionPane.showInputDialog(null,menu()));
            }
            catch(NumberFormatException nfe)
            {
            }

            switch (op1) {
                case 1:
                {

                    try {
                        op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Como desea agregar al empleado/a\n1) Servicio profesional\n2) Plaza fija"));
                    }
                    catch(NumberFormatException nfe)
                    {
                        JOptionPane.showMessageDialog(null, "Error, digite un valor correcto");
                        break;
                    }


                    if (op2>2||op2<0){
                        JOptionPane.showMessageDialog(null,"Error intente de nuevo");
                        break;
                    }
                    else {
                        switch (op2) {
                            case 1: {
                                nombre = JOptionPane.showInputDialog(null, "Nombre del emplado/a:");
                                puesto = JOptionPane.showInputDialog(null, "Puesto que ocupara:");
                                try {
                                    salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario:"));
                                    if (salario < 0) {
                                        throw new Badcode("numeros negativos no validos");
                                    }

                                } catch (Badcode badcode) {
                                    JOptionPane.showMessageDialog(null, "ERROR: " + badcode.getMessage());
                                    break;
                                }catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "Error, digite un numero");
                                    break;
                                }



                                try{
                                cantidadmeses = Integer.parseInt(JOptionPane.showInputDialog(null, "Meses estipulados en el contrato:"));
                                    if (cantidadmeses < 0) {
                                        throw new Badcode("numeros negativos no validos");
                                    }
                                } catch (Badcode badcode) {
                                    JOptionPane.showMessageDialog(null, "ERROR: " + badcode.getMessage());
                                    break;
                                }catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "Error, digite un numero");
                                    break;
                                }

                                Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                ServicioProfesional servicioProfesional = new ServicioProfesional(nombre, puesto, salario, cantidadmeses);
                                corp.addEmpleado(servicioProfesional);
                                Documento documento = new Documento(Nmd, Numdocum);
                                servicioProfesional.documentos.add(documento);
                                do {

                                    try {
                                        op3 = Integer.parseInt(JOptionPane.showInputDialog(null, menu2()));
                                    }
                                    catch(NumberFormatException nfe)
                                    {
                                    }

                                    switch (op3) {
                                        case 1: {
                                            Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                            Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                            Documento documento1 = new Documento(Nmd, Numdocum);
                                            servicioProfesional.documentos.add(documento1);
                                            break;
                                        }
                                        case 2: {
                                            break;
                                        }
                                        default: {
                                            JOptionPane.showMessageDialog(null, "Error digite un valor correcto");
                                            break;
                                        }
                                    }
                                } while (op3 != 2);


                                break;
                            }
                            case 2: {
                                nombre = JOptionPane.showInputDialog(null, "Nombre del emplado/a:");
                                puesto = JOptionPane.showInputDialog(null, "Puesto que ocupara:");
                                try {
                                    salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario:"));
                                    if (salario < 0) {
                                        throw new Badcode("numeros negativos no validos");
                                    }

                                } catch (Badcode badcode) {
                                    JOptionPane.showMessageDialog(null, "ERROR: " + badcode.getMessage());
                                    break;
                                }catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "Error, digite un numero");
                                    break;
                                }

                                try {
                                    extencion = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero telefonico de la oficina:"));
                                    if (extencion < 0) {
                                        throw new Badcode("numeros negativos no validos");
                                    }

                                } catch (Badcode badcode) {
                                    JOptionPane.showMessageDialog(null, "ERROR: " + badcode.getMessage());
                                    break;
                                }catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null, "Error, digite un numero");
                                    break;
                                }

                                PlazaFija plazaFija = new PlazaFija(nombre, puesto, salario, extencion);
                                Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                corp.addEmpleado(plazaFija);
                                Documento documento2 = new Documento(Nmd, Numdocum);
                                plazaFija.documentos.add(documento2);
                                do {

                                    try {
                                        op3 = Integer.parseInt(JOptionPane.showInputDialog(null, menu2()));
                                    }
                                    catch(NumberFormatException nfe)
                                    {
                                    }


                                    switch (op3) {
                                        case 1: {
                                            Nmd = JOptionPane.showInputDialog("Digite el nombre del documento");
                                            Numdocum = JOptionPane.showInputDialog("Digite el numero del documento");
                                            Documento documento3 = new Documento(Nmd, Numdocum);
                                            plazaFija.documentos.add(documento3);
                                            break;
                                        }
                                        case 2: {
                                            break;
                                        }
                                        default: {
                                            JOptionPane.showMessageDialog(null, "Digite un valor correcto");
                                            break;
                                        }
                                    }

                                } while (op3 != 2);
                                break;
                            }


                        }
                        break;
                    }
            }

                case 2: {
                    if (corp.getPlanilla().size()!=0) {
                        borrar = JOptionPane.showInputDialog(null, "Nombre del empleado/a a despedir:");
                        corp.removeEmpleado(borrar);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Error la lista esta vacia.");
                    }
                    break;
                }
                case 3: {

                    if (corp.getPlanilla().size() != 0) {
                        corp.getPlanilla().forEach(obj -> {
                            if (obj instanceof ServicioProfesional) {
                                JOptionPane.showMessageDialog(null, obj.toString());
                            } else if (obj instanceof PlazaFija) {
                                JOptionPane.showMessageDialog(null, obj.toString());
                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta vacia");
                    }
                    break;
                }

                    //elegir nombre y mostrar sueldo de el
                case 4: {
                    if (corp.getPlanilla().size()!=0) {
                        search = JOptionPane.showInputDialog(null, "Nombre a buscar:");
                        String finalSearch = search;
                        corp.getPlanilla().forEach(obj -> {
                            if (obj.getNombre().equals(finalSearch)) {
                                if (obj instanceof ServicioProfesional) {
                                    JOptionPane.showMessageDialog(null, "Sueldo: " + CalculadoraImpuestos.calcularPago(obj) + "$");
                                } else if(obj instanceof PlazaFija) {
                                    JOptionPane.showMessageDialog(null, "Sueldo: " + CalculadoraImpuestos.calcularPago(obj) + "$");
                                }
                            }
                        });
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Error la lista esta vacia");
                    }

                    break;
                }
                case 5: {
                    if (corp.getPlanilla().size() != 0) {
                        JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta vacia.");
                    }
                    break;
                }
                case 6:
                {
                    JOptionPane.showMessageDialog(null,"Que tenga un buen dia");
                    break;
                }
                default:
                {
                    JOptionPane.showMessageDialog(null,"Error, digite un valor valido");
                    break;
                }
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
