package com.example.myapplication.Rechnungen_ueberarbeitet;


import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt1;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt2;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt3;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt4;


import java.util.ArrayList;
import java.util.List;

public class Rechnungen {
    public static Hilfsobjekt1 wieLangeSparen(){
        Hilfsobjekt2 helfer = Hilfsmethoden.frageAbWieLange();

        double z = Hilfsmethoden.umwandelnZuGroesserEins(helfer.zinsenInProzent); //Zinsen
        double sK = helfer.startkapital; //Startkapital
        double zK = helfer.zielkapital; //Zielkapital
        double mS = helfer.monatlichesSparen; //Monatliches Sparen

        Hilfsmethoden hm = new Hilfsmethoden();
        Hilfsobjekt1 ergebnis = hm.berechneWieLange(sK, zK, mS, z);

        System.out.println("Nach " + ergebnis.jahre + " Jahren wird das Zielkapital erreicht und Sie werden "
                + ergebnis.endsumme + " Euro angespart haben, wenn das Startkapital "
                + ergebnis.startkapital + " Euro beträgt und monatlich "
                + ergebnis.monatlichesSparen + " Euro gespart werden.");

        return ergebnis;
    }

    public static void wieVielSparen(){
        Hilfsobjekt3 helfer = Hilfsmethoden.frageAbWieViel();

        double inWvJahren = helfer.inWvJahren;
        double zinsen = Hilfsmethoden.umwandelnZuGroesserEins(helfer.zinsInProzent);
        double wunschKapital = helfer.wunschKapital;
        double startKapital = helfer.startKapital;

        Hilfsmethoden hm = new Hilfsmethoden();
        Hilfsobjekt4 ergebnis = hm.berechneWieViel(inWvJahren, zinsen, wunschKapital, startKapital);

        System.out.println(ergebnis.monate + " = Monatlicher Sparbetrag");
        System.out.println(ergebnis.jahre + " = Jährlicher Sparbetrag");
    }
}