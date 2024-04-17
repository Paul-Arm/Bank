package org.example;

import java.time.*;


public class Person {
    private String name;
    private String vorname;
    private String adresse;
    private final LocalDate geburtsdatum;

    public Person(String name, String vorname, String adresse, LocalDate geburtsdatum) {
        this.name = name;
        this.vorname = vorname;
        this.adresse = adresse;
        this.geburtsdatum = geburtsdatum;
    }

    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", geburtsdatum='" + geburtsdatum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public int getAlter() {
        return Period.between(geburtsdatum, LocalDate.now()).getYears();
    }


}
