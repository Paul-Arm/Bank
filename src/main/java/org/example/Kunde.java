package org.example;


import java.time.LocalDate;
import java.util.OptionalDouble;
import java.util.UUID;

public class Kunde extends Person {
    private KundenProfil kundenProfil;
    private final java.util.UUID kundennummer;
    private Konto ausgewKonto;


    public Kunde(String name, String vorname, String adresse, LocalDate geburtsdatum, KundenProfil kundenProfil) {

        super(name, vorname, adresse, geburtsdatum);
        this.kundennummer = java.util.UUID.randomUUID();
        this.kundenProfil = kundenProfil;
    }

    public Kunde(String name, String vorname, String adresse, LocalDate geburtsdatum, Mitarbeiter betreuer, Filiale filiale) {

        this(name, vorname, adresse, geburtsdatum, new KundenProfil(betreuer, filiale));
    }

    public UUID getKundennummer() {
        return kundennummer;
    }


    public void kontoAuswählen(Konto konto){
        this.ausgewKonto = konto;
    }

    public void neuesKontoHinzufügen(Konto konto){

        if (this.kundenProfil.getKonten().size() <= 4) {
            this.kundenProfil.addKonto(konto);
        }else {
            System.out.println("Kunde hat bereits 5 Konten");
        }
    }

    public void einzahlen(double betrag){
        if (this.ausgewKonto == null){
            System.out.println("Kein Konto ausgewählt");
            return;
        }
        this.ausgewKonto.setKontostandÄnderung(betrag);
        System.out.println( betrag + "€ wurden eingezahlt");

    }

    public void auszahlen(double betrag){
        if (this.ausgewKonto == null){
            System.out.println("Kein Konto ausgewählt");
            return;
        }
        this.ausgewKonto.setKontostandÄnderung(-betrag);
        System.out.println( betrag + "€ wurden ausgezahlt");
    }
    public void kontoLöschen(){
        if (this.ausgewKonto == null){
            System.out.println("Kein Konto ausgewählt");
            return;
        }
        this.kundenProfil.removeKonto(this.ausgewKonto);
        this.ausgewKonto = null;
        // gc collects the object

    }

    public void setKundenProfil( KundenProfil kundenProfil) {
        this.kundenProfil = kundenProfil;
    }

    public KundenProfil getKundenProfil() {
        return this.kundenProfil;
    }

    public OptionalDouble getKontostand(){
        if (this.ausgewKonto == null){
            System.out.println("Kein Konto ausgewählt");
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(this.ausgewKonto.getKontostand());
    }



}

