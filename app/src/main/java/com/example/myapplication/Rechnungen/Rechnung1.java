package com.example.myapplication.Rechnungen;
public class Rechnung1 {

    public static Ergebnis wieLangeSparen(double zinswert, double sK, double zK, double mS) {
        int j = 0; // Jahre bis zum Erreichen des Zielkapitals
        double zinsen;
        double eS; //Endsumme

        /*  sK = Startkapital
            zK = Zielkapital
            mS = Monatliches Sparen */

        zinsen = 1 + 0.01 * zinswert;

        for (eS = sK; eS < zK; eS = eS * zinsen) {
            eS += 12 * mS;
            j += 1;
        }

        return new Ergebnis(j, eS, sK, mS);
                /*"Nach " + j + " Jahren wird das Zielkapital erreicht und Sie werden " + eS +
                " Euro angespart haben, wenn das Startkapital " + sK +
                " Euro beträgt und monatlich " + mS + " Euro gespart werden.";*/
    }

    public static class Ergebnis{
        int jahre;
        double endsumme;
        double startkapital;
        double monatlichesSparen;
        public Ergebnis(int j, double eS, double sK, double mS){
            jahre = j;
            endsumme = eS;
            startkapital = sK;
            monatlichesSparen =mS;
        }
    }
}
