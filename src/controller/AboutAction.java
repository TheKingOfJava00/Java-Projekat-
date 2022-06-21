package controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// AbstractAction http://www.fredosaurus.com/notes-java/GUI/events/actions.html
// omogucava nam da imamo jednu klasu za akciju, posle je samo lepimo gde god nam treba
// odrzavamo funkcionalnost
public class AboutAction extends AbstractAction {


    public AboutAction() {
        super("About");
        putValue(Action.SHORT_DESCRIPTION, "About dialog");
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(Action.SMALL_ICON, new ImageIcon("src/icons/info-16.png"));
    }

    }
}
