package controller;

import app.AppCore;
import com.sun.tools.javac.Main;
import model.Zaposleni;
import view.MainFrame;
import view.table.TableSoftveri;
import view.table.TableZaposleni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractAction {


    public DeleteAction(Boolean withText) {
        if (withText) {
            putValue(Action.NAME, "Delete");
        }
        putValue(Action.SHORT_DESCRIPTION, "Delete entity");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(Action.SMALL_ICON, new ImageIcon("src/icons/delete.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = null;
        int col; int row;
        // Provera koji je tab selektovan, kako bi znali koja tabela je u pitanju
        int tabSelected = AppCore.getMainFrame().getContent().getSelectedIndex();
        if (tabSelected == 0) {
            table = AppCore.getMainFrame().getTableZaposleni();
            // Kolona JMBG
            col = 3;
        } else {
            table = AppCore.getMainFrame().getTableSoftveri();
            // Kolona naziv
            col = 0;
        }

        // Uzimamo selektovani red i ako nista nije selektovano vracamo poruku
        row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No row selected!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entity?", "WARNING",
                JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.OK_OPTION) {
            if (table instanceof TableZaposleni) {
                // Nadjemo zaposlenog po jmbgu u bazi, izbrisemo ga
                String jmbg = table.getModel().getValueAt(row, col).toString();
                AppCore.getDatabase().deleteZaposleni(jmbg);
            }
            if (table instanceof TableSoftveri) {
                // Nadjemo softver po nazivu u bazi, izbrisemo ga
                String naziv = table.getModel().getValueAt(row, col).toString();
                AppCore.getDatabase().deleteSoftver(naziv);
            }
            
            AppCore.getMainFrame().changeTab(tabSelected);
        }
    }
}
