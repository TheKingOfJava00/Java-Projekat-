package controller;

import app.AppCore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OpenSoftveriAction extends AbstractAction {

    public OpenSoftveriAction() {
        super("Softveri");
        putValue(Action.SHORT_DESCRIPTION, "Open softveri");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    }

    
}
