package Kata;

import java.util.Scanner;

public class Durchschnitt {
    public static void main(String[] args) {
        int eingabe = 0, counter = 0, Summe = 0;
        boolean b = true;
        Scanner eingabewert = new Scanner(System.in);

        while(b) {
            System.out.println("Neuen Wert eingeben: (Berechnen durch Eingabe \"0\"");
            eingabe  = eingabewert.nextInt() ;
            counter++;
            b = (eingabe != 0);
            Summe+=eingabe ;
        }
        System.out.println("Durchscnittswert: " + (Summe/(counter - 1) ) + " Gesamstsumme: " + Summe + " Anzahl der Eingaben: " + (counter -1));
    }
}
