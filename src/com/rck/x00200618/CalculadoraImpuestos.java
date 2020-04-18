package com.rck.x00200618;

import javax.swing.*;

public class CalculadoraImpuestos {

    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(double totalRenta, double totalISSS, double totalAFP) {
        this.totalRenta = 0;
        this.totalISSS = 0;
        this.totalAFP = 0;
    }

    public static double calcularPago(Empleado empleado) {
        double total=0,trenta=0,tafp=0,tisss=0;
        if (empleado instanceof ServicioProfesional)
        {

                trenta = 0.1*empleado.getSalario();
                total = empleado.getSalario()-trenta;
        }

        else if (empleado instanceof PlazaFija)
        {
            tafp = 0.0625*empleado.getSalario();
            tisss = 0.03*empleado.getSalario();
            double restante = 0;

            restante = empleado.getSalario()-tafp-tisss;

            if (empleado.getSalario()>=0.01 && empleado.getSalario()<=472)
            {
                trenta=0;
                total = restante;
            }
            else if (empleado.getSalario()>472 && empleado.getSalario()<=895.24)
            {
                trenta = 0.1*(restante-472)+17.67;
                total = restante-trenta;
            }
            else if (empleado.getSalario()>895.24 && empleado.getSalario()<=2038.11)
            {
                trenta = 0.2*(restante-895.24)+60;
                total = restante-trenta;
            }
            else if (empleado.getSalario()>2038.11)
            {
                trenta = 0.3*(restante-2038.10)+288.57;
                total = restante-trenta;
            }
            totalRenta=totalRenta+trenta;
            totalISSS=totalISSS+tisss;
            totalAFP=totalAFP+tafp;
        }
        return total;
    }

    public static String mostrarTotales()
    {
        return "Total AFP= "+totalAFP+" Total renta= "+totalRenta+" Total ISSS= "+totalISSS;
    }




}
