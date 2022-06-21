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

}
