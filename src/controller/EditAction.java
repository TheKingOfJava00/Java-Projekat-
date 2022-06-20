package controller;

import app.AppCore;
import model.Softver;
import model.Zaposleni;
import view.dialog.SoftverDialog;
import view.dialog.ZaposleniDialog;
import view.table.TableSoftveri;
import view.table.TableZaposleni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractAction {

    public EditAction(Boolean withText) {
        if (withText) {
            putValue(Action.NAME, "Edit");
        }
        putValue(Action.SHORT_DESCRIPTION, "Edit entity");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(Action.SMALL_ICON, new ImageIcon("src/icons/edit.png"));
    }

 }
