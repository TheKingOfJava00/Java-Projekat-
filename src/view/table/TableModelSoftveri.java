package view.table;

import app.AppCore;
import model.Softver;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableModelSoftveri extends DefaultTableModel {

    public TableModelSoftveri() {
        String[] colNameSoftveri = {"Naziv", "Cetkice", "Modifikatori", "Formati_fajla", "Animation tools", "Render"};
        // Dodajemo kolone u tabelu za prikaz softvera
        this.setColumnIdentifiers(colNameSoftveri);
        ArrayList<Softver> softveri = AppCore.getDatabase().getSoftveri();
        for (int i = 0; i < softveri.size(); i++) {
            Object[] data = new Object[6];
            data[0] = softveri.get(i).getNaziv();
            data[1] = softveri.get(i).getCetkice();
            data[2] = softveri.get(i).getModifikatori();
            data[3] = softveri.get(i).getFormatiFajla();
            data[4] = softveri.get(i).getAnimationTools();
            data[5] = softveri.get(i).getRender();
            // Dodajemo po jedan red za svaki softver, sa odgovarajucim podacima
            this.addRow(data);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 1 || column == 2 || column == 3 || column == 4 || column == 5;
    }
}
