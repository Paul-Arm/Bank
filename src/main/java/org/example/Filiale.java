package org.example;


import java.util.ArrayList;

public class Filiale {
    private String adresse;

    private ArrayList<Mitarbeiter> mitarbeiter;
    private ArrayList<Kunde> kunden;


    public Filiale(String adresse, ArrayList<Mitarbeiter> mitarbeiter, ArrayList<Kunde> kunden){
        this.adresse = adresse;
        this.mitarbeiter = new ArrayList<Mitarbeiter>();
        this.mitarbeiter.addAll(mitarbeiter);
        this.kunden = new ArrayList<Kunde>();
        this.kunden.addAll(kunden);
    }

    public Filiale(String adresse, ArrayList<Mitarbeiter> mitarbeiter){
        this(adresse, mitarbeiter, new ArrayList<Kunde>());


    }

    public void addKunde(ArrayList<Kunde> kunde){
        this.kunden.addAll(kunde);
    }
    public void removeKunde(Kunde kunde){
        this.kunden.remove(kunde);
    }
    public void addMitarbeiter(ArrayList<Mitarbeiter> mitarbeiter){
        this.mitarbeiter.addAll(mitarbeiter);
    }
    public void removeMitarbeiter(Mitarbeiter mitarbeiter){
        if (this.mitarbeiter.size() > 1){
            System.out.println("Filiale muss mindestens einen Mitarbeiter haben");
            return;
        }
        this.mitarbeiter.remove(mitarbeiter);
    }

    public ArrayList<Mitarbeiter> getMitarbeiter(){
        return this.mitarbeiter;
    }

    public ArrayList<Kunde> getKunden(){
        return this.kunden;
    }
}
