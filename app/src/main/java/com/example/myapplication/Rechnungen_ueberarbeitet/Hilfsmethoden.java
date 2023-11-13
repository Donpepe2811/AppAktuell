package com.example.myapplication.Rechnungen_ueberarbeitet;

import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt1;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt2;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt3;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hilfsmethoden {
    static Scanner sc = new Scanner(System.in);


    public static double umwandelnZuGroesserEins(int i){//bringt nicht so wirklich viel, weil ich
        // im scanner definieren muss, ob ich das nächste double oder int einlesen will
        return 1 + 0.01 * i;
    }
    public static double umwandelnZuGroesserEins(double d){
        return 1 + 0.01 * d;
    }


    public static Hilfsobjekt1 berechneWieLange(double sK, double zK, double mS, double z){
        int j = 0;
        double eS;

        for (eS = sK; eS < zK; eS = eS * z) {
            eS += 12 * mS;
            j += 1;
        }
        return new Hilfsobjekt1(j, eS, sK, mS);
    }


    public Hilfsobjekt4 berechneWieViel(double inWvJahren, double zinsen, double wunschKapital, double startKapital){
        List<Double> alleJahre = new ArrayList<>();
        double exponent = inWvJahren;
        double summeNenner = 0.0;

        for (int i = 1; i <= inWvJahren; i++){
            double d = Math.pow(1 + 0.01 * zinsen, exponent);
            alleJahre.add(d);
            exponent--;
        }

        for (double d : alleJahre){
            summeNenner += d;
        }

        double prozentsatzVonEndsumme = (Math.pow(1 + 0.01 * zinsen, inWvJahren))/summeNenner;
        double jaehrlicherSparbetrag = ((wunschKapital - startKapital *
                Math.pow(1 + 0.01 * zinsen, inWvJahren)) * prozentsatzVonEndsumme)/
                (Math.pow(1 + 0.01 * zinsen, inWvJahren));
        double monatlicherSparbetrag = jaehrlicherSparbetrag/12;
        return new Hilfsobjekt4(monatlicherSparbetrag, jaehrlicherSparbetrag);
    }


    public static Hilfsobjekt2 frageAbWieLange(){
        System.out.println("Bitte geben Sie an, wie viel Startkapital Sie zum investieren haben.");
        double sK = sc.nextDouble();
        System.out.println("Bitte geben Sie an, was Ihr Zielkapital ist.");
        double zK = sc.nextDouble();
        System.out.println("Bitte geben Sie an, wie viel Sie monatlich sparen möchten.");
        double mS = sc.nextDouble();
        System.out.println("Bitte geben Sie in Prozent an, wie viel Zinsen Sie bekommen.");
        double zP = sc.nextDouble();
        /*double zP = -100;
        try { //trycatch nochmal testen + verbessern
            double zp = sc.nextDouble();
        } catch (IllegalArgumentException E){
            System.out.println("Etwas hat nicht funktioniert.");
            System.out.println("Bitte geben Sie den Zinssatz ohne Prozentzeichen ein.");
            // An dieser Stelle Abfrage neu aufrufen, aber vorher eingegebene werte benutzen
            //sodass der nutzer nicht alles neu eingeben muss
        }*/
        return new Hilfsobjekt2(sK, zK, mS, zP);
    }


    public static Hilfsobjekt3 frageAbWieViel(){
        System.out.println("Bitte geben Sie an, wie viel Startkapital Sie zum investieren haben.");
        double startKapital = sc.nextDouble();
        System.out.println("Bitte geben Sie an, was Ihr Zielkapital ist.");
        double wunschKapital = sc.nextDouble();
        System.out.println("Bitte geben Sie an, in wie vielen Jahren Sie ihr Zielkapital erreicht haben möchten.");
        double inWvJahren = sc.nextDouble();
        System.out.println("Bitte geben Sie in Prozent an, wie viel Zinsen Sie bekommen.");
        double zinsInProzent = sc.nextDouble();
        return new Hilfsobjekt3(inWvJahren, zinsInProzent, wunschKapital, startKapital);
    }
}
