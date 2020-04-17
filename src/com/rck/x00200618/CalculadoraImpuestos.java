package com.rck.x00200618;

import javax.swing.*;

public class CalculadoraImpuestos {

    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(double totalRenta, double totalISSS, double totalAFP) {
        this.totalRenta = totalRenta;
        this.totalISSS = totalISSS;
        this.totalAFP = totalAFP;
    }

    public static double calcularPago(Empleado empleado)
    {

        if (empleado instanceof ServicioProfesional)
        {
                double total=0;

                totalRenta = 0.1*empleado.getSalario();
                total = empleado.getSalario()-totalRenta;
                return total;
        }

        else if (empleado instanceof PlazaFija)
        {
            double total=0;

            totalAFP = 0.0625*empleado.getSalario();
            totalISSS = 0.03*empleado.getSalario();
            double restante = 0;

            restante = empleado.getSalario()-totalAFP-totalISSS;

            if (empleado.getSalario()>=0.01 && empleado.getSalario()<=472)
            {
                totalRenta=0;
                total = restante;
                return total;
            }
            else if (empleado.getSalario()>472 && empleado.getSalario()<=895.24)
            {
                totalRenta = 0.1*(restante-472)+17.67;
                total = restante-totalRenta;
                return total;
            }
            else if (empleado.getSalario()>895.24 && empleado.getSalario()<=2038.11)
            {
                totalRenta = 0.2*(restante-895.24)+60;
                total = restante-totalRenta;
                return total;
            }
            else if (empleado.getSalario()>2038.11)
            {
                totalRenta = 0.3*(restante-2038.10)+288.57;
                total = restante-totalRenta;
                return total;
            }
        }


    }

    //acabar
    public static String mostrarTotales()
    {


    }




}
