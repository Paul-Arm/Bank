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

    public Mitarbeiter(String name, String vorname, String adresse,
                       LocalDate geburtsdatum, Filiale filiale){
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
            System.out.println("Kunde muss mindestens 18 Jahre alt sein");
            return false;
        }

        KundenProfil kundenProfil = new KundenProfil( betreuer, filiale);
        kunde.setKundenProfil(kundenProfil);
        filiale.addKunde(new ArrayList<Kunde>(){{add(kunde);}});
        System.out.println("Kundenprofil erstellt in: " + filiale);
        betreuer.kundeZuweisen(kunde);
        return true;


    }
    public void kundenProfilBearbeiten(KundenProfil kundenProfil, Filiale neueFiliale){
        kundenProfil.setFiliale(neueFiliale);
    }
    public void kundenProfilBearbeiten(KundenProfil kundenProfil, Mitarbeiter neuerBetreuer){
        kundenProfil.setBetreuer(neuerBetreuer);
    }

    public void kundenprofilLöschen(KundenProfil kundenProfil){

        for (Konto konto : kundenProfil.getKonten()){
            if (konto.getKontostand() != 0){
                System.out.println("Mindestens ein Konto des Kunden ist nicht leer, daher kann der Kunde nicht gelöscht werden");
                return;
            }
        }
        Mitarbeiter mitarbeiter = kundenProfil.getBetreuer();
        Kunde kunde = mitarbeiter.betreuteKunden.stream().filter(x -> kundenProfil.equals(x.getKundenProfil()))
                .findFirst()
                .orElse(null);

        // remove profile from filiale
        Filiale f = kundenProfil.getFiliale();
        f.removeKunde(kunde);



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
