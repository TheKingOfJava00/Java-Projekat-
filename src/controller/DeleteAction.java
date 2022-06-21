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

    }
}
