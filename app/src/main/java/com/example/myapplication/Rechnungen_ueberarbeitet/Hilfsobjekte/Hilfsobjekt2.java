package com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte;

public class Hilfsobjekt2 {
    //für Methode berechneWieLange
    public double startkapital;
    public double zielkapital;
    public double monatlichesSparen;
    public double zinsenInProzent;

    public Hilfsobjekt2(double sK, double zK, double mS, double zP) {
        startkapital = sK;
        zielkapital = zK;
        monatlichesSparen = mS;
        zinsenInProzent = zP;
    }
}
