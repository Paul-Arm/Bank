package org.example;


import java.util.ArrayList;

public class Filiale {

    private ArrayList<Mitarbeiter> mitarbeiter;
    private ArrayList<Kunde> kunden = new ArrayList<Kunde>();


    public Filiale(Mitarbeiter mitarbeiter){
        this.mitarbeiter = new ArrayList<Mitarbeiter>();
        this.mitarbeiter.add(mitarbeiter);
    }

    public void addKunde(Kunde kunde){
        this.kunden.add(kunde);
    }
    public void removeKunde(Kunde kunde){
        this.kunden.remove(kunde);
    }
    public void addMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter.add(mitarbeiter);
    }
    public void removeMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter.remove(mitarbeiter);
    }

    public ArrayList<Mitarbeiter> getMitarbeiter(){
        return this.mitarbeiter;
    }

    public ArrayList<Kunde> getKunden(){
        return this.kunden;
    }
}
