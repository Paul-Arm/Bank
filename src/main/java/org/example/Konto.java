package org.example;

public class Konto {

    private double kontostand;
    private  final java.util.UUID kontonummer;

    public Konto(){
        this.kontostand = 0;
        this.kontonummer = java.util.UUID.randomUUID();
    }

    public void setKontostandÄnderung(double betrag){
        if(this.kontostand + betrag >= 0){
            this.kontostand += betrag;

        }else {
            System.out.println("Kontostand darf nicht negativ werden");
        }

    }

    public double getKontostand(){
        return this.kontostand;
    }


    public java.util.UUID getKontonummer(){
        return this.kontonummer;
    }
}
