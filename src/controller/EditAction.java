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

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = null;
        int col; int row;
        int tabSelected = AppCore.getMainFrame().getContent().getSelectedIndex();
        if (tabSelected == 0) {
            table = AppCore.getMainFrame().getTableZaposleni();
            col = 3;
        } else {
            table = AppCore.getMainFrame().getTableSoftveri();
            col = 0;
        }

        row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No row selected!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JDialog dialog = null;
        if (table instanceof TableZaposleni) {
            String jmbg = table.getModel().getValueAt(row, col).toString();
            Zaposleni z = AppCore.getDatabase().findZaposleni(jmbg);
            dialog = new ZaposleniDialog(z);
        }

        if (table instanceof TableSoftveri) {
            String naziv = table.getModel().getValueAt(row, col).toString();
            Softver s = AppCore.getDatabase().findSoftver(naziv);
            dialog = new SoftverDialog(s);
        }

        dialog.setVisible(true);
    }
}
