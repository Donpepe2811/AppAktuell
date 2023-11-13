package com.example.myapplication.Rechnungen;

import java.util.ArrayList;
import java.util.List;

public class Rechnung2 {

    public static Ergebnis wieVielSparen(double inWvJahren, double zinsSatz, double wunschKapital, double startKapital){
        List<Double> alleJahre = new ArrayList<>();
        double exponent = inWvJahren;
        double summeNenner = 0.0;

        for (int i = 1; i <= inWvJahren; i++){
            double d = Math.pow(1 + 0.01 * zinsSatz, exponent);
            alleJahre.add(d);
            //wenn ich hier immer d einer variablen hinzufüge hätte ich mir die Arraylist sparen können
            exponent--;
        }

        for (double d : alleJahre){
            summeNenner += d;
        }

        double prozentsatzVonEndsumme = (Math.pow(1 + 0.01 * zinsSatz, inWvJahren))/summeNenner;
        double jaehrlicherSparbetrag = ((wunschKapital - startKapital * Math.pow
                (1 + 0.01 * zinsSatz, inWvJahren)) * prozentsatzVonEndsumme)
                / (Math.pow(1 + 0.01 * zinsSatz, inWvJahren));

        return new Ergebnis(jaehrlicherSparbetrag);
    }

    public static class Ergebnis{
        double monatlicherSparbetrag;
        double jaehrlicherSparbetrag;
        Ergebnis(double j){
            jaehrlicherSparbetrag = j;
            monatlicherSparbetrag = j/12;
        }
    }
}
