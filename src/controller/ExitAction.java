package controller;

import app.AppCore;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractAction {

    public ExitAction() {
        super("Exit");
        putValue(Action.SHORT_DESCRIPTION, "Close app");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(Action.SMALL_ICON, new ImageIcon("src/icons/exit.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame frame = AppCore.getMainFrame();
        // Zatvara prozor aplikacije
        frame.dispose();
    }
}
