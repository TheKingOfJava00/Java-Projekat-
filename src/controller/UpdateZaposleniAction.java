package controller;

import app.AppCore;
import model.Adresa;
import model.RadnoMesto;
import model.Softver;
import model.Zaposleni;
import view.dialog.ZaposleniDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

// Akcija za dodavanje novog i update starog zaposlenog
public class UpdateZaposleniAction implements ActionListener {

    private ZaposleniDialog dialog;

    public UpdateZaposleniAction(ZaposleniDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ime = dialog.getTfIme().getText();
        String prezime = dialog.getTfPrezime().getText();
        String jmbg = dialog.getTfJmbg().getText();
        String datum = dialog.getTfDatumRodjenja().getText();
        String email = dialog.getTfEmail().getText();
        String ulica = dialog.getTfUlica().getText();
        String broj = dialog.getTfBroj().getText();
        String grad = dialog.getTfGrad().getText();
        RadnoMesto radnoMesto = (RadnoMesto) dialog.getCbRadnoMesto().getSelectedItem();
        List<Softver> softveri = dialog.getListSoftveri().getSelectedValuesList();


        // Provera da li su sva polja popunjena (bez praznih polja)
        if (ime.equals("") || prezime.equals("") || jmbg.equals("") || datum.equals("")
                || email.equals("") || ulica.equals("") || broj.equals("") || grad.equals("")) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // https://www.baeldung.com/java-8-date-time-intro
        LocalDate datumRodjenja = null;
        try {
            datumRodjenja = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException exception) {
            JOptionPane.showMessageDialog(null, "Invalid date format!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Zaposleni zaposleni = dialog.getZaposleni();

    }
}
