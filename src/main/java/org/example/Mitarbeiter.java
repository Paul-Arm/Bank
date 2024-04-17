package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mitarbeiter extends Person{
    private java.util.UUID mitarbeiterNummer;
    private Filiale filiale;
    private ArrayList<Kunde> betreuteKunden;


    public Mitarbeiter(String name, String vorname, String adresse, LocalDate geburtsdatum){
        this(name, vorname, adresse, geburtsdatum, null);

    }

    public Mitarbeiter(String name, String vorname, String adresse, LocalDate geburtsdatum, Filiale filiale){
        super(name, vorname, adresse, geburtsdatum);
        this.mitarbeiterNummer = java.util.UUID.randomUUID();
        this.filiale = filiale;
        this.betreuteKunden = new ArrayList<Kunde>();

    }
    public String getMiarbeiternummer(){
        return String.valueOf(this.mitarbeiterNummer);
    }

    public Boolean kundenprofilErstellen(String name,
                                         String vorname,
                                         String adresse,
                                         LocalDate geburtsdatum,
                                         Mitarbeiter betreuer,
                                         Filiale filiale){
        Kunde kunde = new Kunde(name, vorname, adresse, geburtsdatum, betreuer, filiale);
        if (kunde.getAlter() < 18){
            return false;
        }

        KundenProfil kundenProfil = new KundenProfil( betreuer, filiale);
        kunde.setKundenProfil(kundenProfil);
        filiale.addKunde(kunde);
        System.out.println("Kundenprofil erstellt in: " + filiale);
        betreuer.kundeZuweisen(kunde);
        return true;


    }

    public void kundenprofilLöschen(KundenProfil kundenProfil){

        Mitarbeiter mitarbeiter = kundenProfil.getBetreuer();
        Kunde kunde = mitarbeiter.betreuteKunden.stream().filter(x -> kundenProfil.equals(x.getKundenProfil()))
                .findFirst()
                .orElse(null);
        this.filiale.removeKunde(kunde);
        kunde.getKundenProfil().getBetreuer().betreuteKunden.remove(kunde);
        kunde.setKundenProfil(null);


    }
    public void kundeZuweisen(Kunde kunde){
        this.betreuteKunden.add(kunde);
    }

    public ArrayList<Kunde> getBetreuteKunden(){
        return this.betreuteKunden;
    }

}
