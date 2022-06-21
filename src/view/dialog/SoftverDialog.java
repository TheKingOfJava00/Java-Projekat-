package view.dialog;

import app.AppCore;
import controller.UpdateSoftverAction;
import model.Cetkica;
import model.Render;
import model.Softver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SoftverDialog extends JDialog {

    private Softver softver;

    private JTextField tfNaziv;
    private JList<Cetkica> listCetkice;
    private JTextField listModifikatori;
    private JTextField listFormati;
    private JTextField listAnimationTools;
    private Render render;
    private JButton btnOk;
    private JButton btnCancel;


    public SoftverDialog(Softver softver) {
        this.softver = softver;
        if (softver != null) {
            this.render = softver.getRender();
        }

        tfNaziv = new JTextField();
        listModifikatori = new JTextField();
        listModifikatori.setToolTipText("Modifikatori separated by semicolon");
        listFormati = new JTextField();
        listFormati.setToolTipText("Formati fajla separated by semicolon");
        listAnimationTools = new JTextField();
        listAnimationTools.setToolTipText("Animation tools separated by semicolon");

        DefaultListModel<Cetkica> listModel = new DefaultListModel<>();
        listCetkice = new JList<>(listModel);
        ArrayList<Cetkica> cetkice = AppCore.getDatabase().getCetkice();
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < cetkice.size(); i++) {
            listModel.addElement(cetkice.get(i));
            if (softver != null && softver.getCetkice().contains(cetkice.get(i))) {
                indices.add(i);
            }
        }
        listCetkice.setSelectedIndices(indices.stream().mapToInt(i -> i).toArray());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(listCetkice);
        listCetkice.setLayoutOrientation(JList.VERTICAL);

        btnOk = new JButton("OK");
        btnCancel = new JButton("CANCEL");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnOk);
        btnPanel.add(btnCancel);
        btnCancel.addActionListener(e -> dispose());

        if (softver == null) {
            addSoftver();
        } else {
            editSoftver();
        }

        JPanel contentPanel = new JPanel(new GridLayout(6, 2));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.add(new JLabel("Naziv"));
        contentPanel.add(tfNaziv);
        contentPanel.add(new JLabel("Modifikatori"));
        contentPanel.add(listModifikatori);
        contentPanel.add(new JLabel("Formati fajla"));
        contentPanel.add(listFormati);
        contentPanel.add(new JLabel("Animation tools"));
        contentPanel.add(listAnimationTools);
        contentPanel.add(new JLabel("Cetkice"));
        contentPanel.add(scrollPane);
        contentPanel.add(new JLabel("Render"));
        JButton btnRender = new JButton("Render");

       
    }
