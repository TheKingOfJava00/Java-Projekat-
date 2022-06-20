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
                    }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 1 || column == 2 || column == 3 || column == 4 || column == 5;
    }
}
