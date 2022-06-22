package utils;

import app.AppCore;
import model.Cetkica;
import model.Render;

import java.util.ArrayList;


// Klasa zaduzena za generisanje podataka za bazu podataka
public class DatabaseUtil {

    private static final int ENTITY_COUNT = 30;

    public static void populateDatabase() {
        // Ucitavamo softvere
        loadSoftveri();
        // Ucitavamo zaposlene
        loadZaposleni();
    }

    private static void loadZaposleni() {
        //TODO
    }

    private static void loadSoftveri() {

        Cetkica cetkica1 = new Cetkica("Standard", "Standard cetkica", "BLUE");
        Cetkica cetkica2 = new Cetkica("Smooth", "Smooth cetkica", "RED");
        Cetkica cetkica3 = new Cetkica("Remove", "Remove cetkica", "GREEN");
        Cetkica cetkica4 = new Cetkica("Deform", "Deform cetkica", "MAGENTA");
        Cetkica cetkica5 = new Cetkica("Flatten", "Flatten cetkica", "YELLOW");
        ArrayList<Cetkica> cetkice = new ArrayList<>();
        cetkice.add(cetkica1);
        cetkice.add(cetkica2);
        cetkice.add(cetkica3);
        cetkice.add(cetkica4);
        cetkice.add(cetkica5);

        AppCore.getDatabase().setCetkice(cetkice);
    }

}
