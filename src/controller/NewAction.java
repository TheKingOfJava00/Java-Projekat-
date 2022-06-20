package controller;

import app.AppCore;
import view.dialog.SoftverDialog;
import view.dialog.ZaposleniDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewAction extends AbstractAction {

    private String name;

    public NewAction(Boolean withText, String name) {
        this.name = name;
        if (withText) {
            putValue(Action.NAME, name);
        }
        putValue(Action.SHORT_DESCRIPTION, "Add entity");
        if (name == null) {
            putValue(Action.SMALL_ICON, new ImageIcon("src/icons/new.png"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = null;
        if (name == null) {
            // Ako smo akciji pristupili iz toolbara, dohvatamo trenutno selektovani tab i otvaramo odgovarajuci dialog
            int index = AppCore.getMainFrame().getContent().getSelectedIndex();
            if (index == 0) {
                dialog = new ZaposleniDialog(null);
            } else {
                dialog = new SoftverDialog(null);
            }
        } else if (name.equals("Zaposleni")){
            dialog = new ZaposleniDialog(null);
        } else {
            dialog = new SoftverDialog(null);
        }

        dialog.setVisible(true);
    }
}
