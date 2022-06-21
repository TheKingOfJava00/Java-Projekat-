package controller;

import app.AppCore;
import model.Cetkica;
import model.Render;
import model.Softver;
import view.dialog.SoftverDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Akcija za dodavanje novog i update starog softvera
public class UpdateSoftverAction implements ActionListener {

    SoftverDialog dialog;

    public UpdateSoftverAction(SoftverDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String naziv = dialog.getTfNaziv().getText();
        // https://stackoverflow.com/questions/6026813/converting-string-array-to-java-util-list
        ArrayList<String> modifikatori = new ArrayList<>(Arrays.asList(dialog.getListModifikatori().getText().split(";")));
        ArrayList<String> formatiFajla = new ArrayList<>(Arrays.asList(dialog.getListFormati().getText().split(";")));
        ArrayList<String> animationTools = new ArrayList<>(Arrays.asList(dialog.getListAnimationTools().getText().split(";")));
        List<Cetkica> cetkice = dialog.getListCetkice().getSelectedValuesList();
        Render render = dialog.getRender();

        // Provera da li su sva polja popunjena(bez praznih polja)
        if (naziv.equals("") || modifikatori.size() == 0 || formatiFajla.size() == 0|| animationTools.size() == 0
                || cetkice.size() == 0 || render == null) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Softver softver = dialog.getSoftver();

        // Ako je softver null, pravimo novi softver i dodajemo ga u listu softvera
        boolean success = true;
        if (softver == null) {
            softver = new Softver(naziv, (ArrayList<Cetkica>) cetkice, modifikatori, formatiFajla, animationTools, render);
            success = AppCore.getDatabase().addSoftver(softver);
            if (success) {
                softver.addObserver(AppCore.getMainFrame());
                AppCore.getMainFrame().changeTab(1);
                dialog.dispose();
                return;
            }
        }

        // Provera da li softver sa tim nazivom vec postoji
        if (!success || AppCore.getDatabase().findSoftver(naziv) != null && AppCore.getDatabase().findSoftver(naziv) != softver) {
            JOptionPane.showMessageDialog(null, "Softver with that naziv already exists!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ako je vec postojeci, radimo update starih vrednosti
        softver.setNaziv(naziv);
        softver.setModifikatori(modifikatori);
        softver.setFormatiFajla(formatiFajla);
        softver.setAnimationTools(animationTools);
        softver.setCetkice((ArrayList<Cetkica>) cetkice);
        softver.setRender(render);

        AppCore.getMainFrame().changeTab(1);

        dialog.dispose();

    }
}
