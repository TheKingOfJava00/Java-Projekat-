package view.table;

import app.AppCore;
import model.Zaposleni;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableModelZaposleni extends DefaultTableModel {

    public TableModelZaposleni() {
        String[] colNamesZaposleni = {"Ime", "Prezime", "Datum_rodjenja", "JMBG", "Email", "Adresa", "Softveri", "Radno_mesto"};
        // Dodajemo kolone u tabelu za prikaz zaposlenih
        this.setColumnIdentifiers(colNamesZaposleni);
        ArrayList<Zaposleni> zaposleni = AppCore.getDatabase().getZaposleni();
        for (int i = 0; i < zaposleni.size(); i++) {
            Object[] data = new Object[8];
            data[0] = zaposleni.get(i).getIme();
            data[1] = zaposleni.get(i).getPrezime();
            data[2] = zaposleni.get(i).getDatumRodjenja();
            data[3] = zaposleni.get(i).getJmbg();
            data[4] = zaposleni.get(i).getEmail();
            data[5] = zaposleni.get(i).getAdresa().toString();
            data[6] = zaposleni.get(i).getSoftveriForTable();
            data[7] = zaposleni.get(i).getRadnoMesto().toString();
            // Dodajemo po jedan red za svakog zaposlenog, sa odgovarajucim podacima
            this.addRow(data);
        }
    }


    // Metoda koja vraca da li je moguce editovati odredjeno polje u tabeli
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 6;
    }
}
