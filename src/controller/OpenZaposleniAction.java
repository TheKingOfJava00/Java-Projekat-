package controller;

import app.AppCore;
import model.Database;
import model.Zaposleni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OpenZaposleniAction extends AbstractAction {

    public OpenZaposleniAction() {
        super("Zaposleni");
        putValue(Action.SHORT_DESCRIPTION, "Open zaposleni");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Menjamo aktivni tab na tabelu zaposlenih
        AppCore.getMainFrame().changeTab(0);
    }
}
