package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Mitarbeiter max = new Mitarbeiter( "Max", "Mustermann",
                                    "Musterstrasse 1",
                                    LocalDate.of(2020, 1, 8));

        System.out.println(max);
        Filiale filiale1 = new Filiale(max);
        System.out.println("Mitarbeiter in filiale: " + filiale1.getMitarbeiter());
        //Kunde klaus = new Kunde("Klaus", "Klausen", "Klausstrasse 1", LocalDate.of(2020, 1, 8));
        max.kundenprofilErstellen("Klaus",
                                "Klausen",
                                "Teststrasse 1",
                                LocalDate.of(2001, 1, 8),
                                    max,
                                    filiale1);

        System.out.println("Kunden in filiale: " + filiale1.getKunden());

        // find Kunde where name is Klaus
        Kunde klaus = max.getBetreuteKunden().stream()
                .filter(x -> x.getName().equals("Klaus"))
                .findFirst().orElse(null);
        KundenProfil klausKundenprofil = klaus.getKundenProfil();
        Konto klausKonto1 = klausKundenprofil.getKonten().get(0);
        klaus.kontoAuswählen(klausKonto1);

        System.out.println("Mitarbeiter betreut: " + max.getBetreuteKunden());

        // ein und auszahlen
        klaus.einzahlen(1000);
        System.out.println(klausKonto1.getKontostand());
        klaus.auszahlen(500);
        System.out.println(klaus.getKontostand());

        // erstelle neues Konto
        System.out.println("Klaus erstellt neues Konto: ");
        klaus.neuesKontoHinzufügen(new Konto());
        // neues konto auswählen
        klaus.kontoAuswählen(klausKundenprofil.getKonten().get(1));
        System.out.println(klaus.getKontostand() + "€");

        // lösche 2. konto
        System.out.println("lösche 2. Konto (aktives)");
        klaus.kontoLöschen();
        System.out.println(klaus.getKontostand() + "€");

        // aktivier 1. konto
        klaus.kontoAuswählen(klausKundenprofil.getKonten().get(0));

        max.kundenprofilLöschen(klausKundenprofil);
        klaus = null;
        //System.out.println(klaus.getKontostand());

        //kunden anzeigen
        System.out.println("Kunden: " + filiale1.getKunden());
        System.out.println("Mitarbeiter betreut: " + max.getBetreuteKunden());

    }

}