package view.dialog;

import app.AppCore;
import controller.UpdateZaposleniAction;
import model.RadnoMesto;
import model.Softver;
import model.Zaposleni;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ZaposleniDialog extends JDialog {

    private Zaposleni zaposleni;

    private JTextField tfIme;
    private JTextField tfPrezime;
    private JTextField tfJmbg;
    private JTextField tfDatumRodjenja;
    private JTextField tfEmail;
    private JTextField tfUlica;
    private JTextField tfBroj;
    private JTextField tfGrad;
    private JComboBox<RadnoMesto> cbRadnoMesto;
    private JList<Softver> listSoftveri;
    private JButton btnOk;
    private JButton btnCancel;

    public ZaposleniDialog(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;

        tfIme = new JTextField();
        tfPrezime = new JTextField();
        tfJmbg = new JTextField();
        tfEmail = new JTextField();
        tfUlica = new JTextField();
        tfBroj = new JTextField();
        tfGrad = new JTextField();
        tfDatumRodjenja = new JTextField();
        cbRadnoMesto = new JComboBox<>();


        tfUlica.setPreferredSize(new Dimension(150, 50));
        tfGrad.setPreferredSize(new Dimension(150, 50));
        JPanel adresaPanel = new JPanel(new BorderLayout());
        adresaPanel.add(tfUlica, BorderLayout.WEST);
        adresaPanel.add(tfBroj, BorderLayout.CENTER);
        adresaPanel.add(tfGrad, BorderLayout.EAST);

        cbRadnoMesto.addItem(RadnoMesto.ANIMATOR);
        cbRadnoMesto.addItem(RadnoMesto.ILUSTRATOR);
        cbRadnoMesto.addItem(RadnoMesto.MODELATOR);
        cbRadnoMesto.addItem(RadnoMesto.RIGER);



        // http://www.seasite.niu.edu/cs580java/JList_Basics.htm
        DefaultListModel<Softver> listModel = new DefaultListModel<>();
        listSoftveri = new JList<>(listModel);
        ArrayList<Softver> softveri = AppCore.getDatabase().getSoftveri();
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < softveri.size(); i++) {
            listModel.addElement(softveri.get(i));
            if (zaposleni != null && zaposleni.getSoftveri().contains(softveri.get(i))) {
                indices.add(i);
            }
        }
        // https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
        listSoftveri.setSelectedIndices(indices.stream().mapToInt(i -> i).toArray());


        // https://www.tutorialspoint.com/how-to-add-scrollbar-to-jlist-in-java
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(listSoftveri);
        listSoftveri.setLayoutOrientation(JList.VERTICAL);


        btnOk = new JButton("OK");
        btnCancel = new JButton("CANCEL");

        if (zaposleni == null) {
            addZaposleni();
        } else {
            editZaposleni();
        }

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnOk);
        btnOk.addActionListener(new UpdateZaposleniAction(this));
        btnPanel.add(btnCancel);
        btnCancel.addActionListener(e -> dispose());

        JPanel contentPanel = new JPanel(new GridLayout(9, 2));
        contentPanel.setBorder(new EmptyBorder(20, 30, 10, 30));
        contentPanel.add(new JLabel("Ime"));
        contentPanel.add(tfIme);
        contentPanel.add(new JLabel("Prezime"));
        contentPanel.add(tfPrezime);
        contentPanel.add(new JLabel("Jmbg"));
        contentPanel.add(tfJmbg);
        contentPanel.add(new JLabel("Datum rodjenja"));
        contentPanel.add(tfDatumRodjenja);
        contentPanel.add(new JLabel("Email"));
        contentPanel.add(tfEmail);
        contentPanel.add(new JLabel("Adresa(Ulica,Broj,Grad)"));
        contentPanel.add(adresaPanel);
        contentPanel.add(new JLabel("Radno mesto"));
        contentPanel.add(cbRadnoMesto);
        contentPanel.add(new JLabel("Softveri"));
        contentPanel.add(scrollPane);

        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);


        setSize(800, 600);
        setLocationRelativeTo(null);
    }


}
