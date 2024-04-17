package org.example;

import java.util.ArrayList;

public class KundenProfil {

    private Filiale filiale;
    private Mitarbeiter betreuer;

    private ArrayList<Konto> konten;




    public KundenProfil(Mitarbeiter betreuer, Filiale filiale, ArrayList<Konto> konten){
        this.betreuer = betreuer;
        this.filiale = filiale;
        this.konten = konten;
    }
    public KundenProfil(Mitarbeiter betreuer, Filiale filiale){
        Konto erstesKonto = new Konto();
        ArrayList<Konto> firstKonto = new ArrayList<Konto>();
        firstKonto.add(erstesKonto);
        this.konten = firstKonto;
        this.betreuer = betreuer;
        this.filiale = filiale;

    }

    public void addKonto(Konto konto){
        this.konten.add(konto);
    }
    public void removeKonto(Konto konto){
        if (this.konten.size() > 1 && konto.getKontostand() == 0){

            this.konten.remove(konto);
        } else if (konto.getKontostand() != 0) {
            System.out.println("Konto darf nicht gelöscht werden, da noch Geld auf dem Konto ist");

        } else
        {
            System.out.println("Kunde muss mindestens ein Konto haben");
        }

    }
    public ArrayList<Konto> getKonten(){
        return this.konten;
    }
    public void setFiliale(Filiale filiale){
        this.filiale = filiale;
    }
    public Filiale getFiliale(){
        return this.filiale;
    }

    public void setBetreuer(Mitarbeiter betreuer) {
        this.betreuer = betreuer;
    }
    public Mitarbeiter getBetreuer(){
        return this.betreuer;
    }




}
