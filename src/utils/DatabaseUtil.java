package utils;

import app.AppCore;
import model.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;


// Klasa zaduzena za generisanje podataka za bazu podataka
public class DatabaseUtil {

    private static final int ENTITY_COUNT = 5;

    public static void populateDatabase() {
        // Ucitavamo softvere
        loadSoftveri();
        // Ucitavamo zaposlene
        loadZaposleni();
    }

    private static void loadZaposleni() {
        for (int i = 0; i < ENTITY_COUNT; i++) {
            String ime = "Zaposleni" + i;
            String prezime = "Zaposlenovic" + i;
            String jmbg = "" + 10 * i;
            LocalDate datumRodj = LocalDate.now();
            String email = "zaposleni" + i + "@gmail.com";
            Adresa adresa = new Adresa(i, "Ulica" + i, "Grad" + i);
            ArrayList<Softver> softveri = new ArrayList<>();
            for (int k = 0; k < 5; k++) {
                softveri.add(AppCore.getDatabase().getSoftveri().get(k));
            }
            Zaposleni z = new Zaposleni(ime, prezime, jmbg, datumRodj, email, adresa, RadnoMesto.ANIMATOR, softveri);
            z.addObserver(AppCore.getDatabase());
            AppCore.getDatabase().addZaposleni(z);
        }
    }

    private static void loadSoftveri() {
        for (int i = 0; i < ENTITY_COUNT; i++) {
            String naziv = "Softver" + i;
            ArrayList<String> modifikatori = new ArrayList<>();
            ArrayList<String> formatiFajla = new ArrayList<>();
            ArrayList<String> animationTools = new ArrayList<>();
            ArrayList<String> materijali = new ArrayList<>();
            ArrayList<String> kamere = new ArrayList<>();
            ArrayList<String> objekti = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                modifikatori.add(("Modifikator" + i) + j);
                formatiFajla.add(("Format" + i) + j);
                animationTools.add(("AnimationTool" + i) + j);
                materijali.add(("Materijal" + i) + j);
                kamere.add(("Kamera" + i) + j);
                objekti.add(("Objekat" + i) + j);
            }

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

            Render render = new Render();
            render.setNaziv("Render" + i);
            render.setSvetlo("Svetlo" + i);
            render.setMaterijali(materijali);
            render.setKamere(kamere);
            render.setObjekti(objekti);

            AppCore.getDatabase().getRenderi().add(render);

            //https://stackoverflow.com/questions/8115722/generating-unique-random-numbers-in-java
            Random rand = new Random();
            ArrayList<Integer> integerList = new ArrayList<>();
            ArrayList<Cetkica> cetkiceList = new ArrayList<>();
            for (int k = 0; k < cetkice.size(); k++) {
                integerList.add(k);
            }
            Collections.shuffle(integerList);
            for (int k = 0; k < 5; k++) {
                cetkiceList.add(cetkice.get(integerList.get(k)));
            }
            Softver softver = new Softver(naziv, cetkiceList, modifikatori, formatiFajla, animationTools, render);
            AppCore.getDatabase().addSoftver(softver);

        }
    }

}
