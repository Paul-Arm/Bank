package org.example;

public class Konto {

    private double kontostand;
    private  final java.util.UUID kontoNummer;

    public Konto(){
        this.kontostand = 0;
        this.kontoNummer = java.util.UUID.randomUUID();
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


    public java.util.UUID getKontoNummer(){
        return this.kontoNummer;
    }
}
