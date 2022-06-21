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

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JLabel lblAbout = new JLabel();
        // https://stackoverflow.com/questions/2152742/java-swing-multiline-labels
        lblAbout.setText("<html>Nesto o meni <br> Nesto o meni <br> Nesto o meni");
        contentPanel.add(lblAbout);

        JDialog dialog = new JDialog();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (screenSize.width * 0.3);
        int h = (int) (screenSize.height * 0.4);
        dialog.setSize(w, h);

        dialog.setLayout(new BorderLayout());
        dialog.add(contentPanel, BorderLayout.CENTER);

        dialog.setLocationRelativeTo(null);
        dialog.setTitle("About");
        dialog.setVisible(true);
    }
}
