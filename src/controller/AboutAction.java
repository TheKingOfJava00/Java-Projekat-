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
        lblAbout.setText("<html>Antonije Katrina AI 21/2019-TheKingOfJava00 <br> model,observer,utils, deo controller-a <br> <br> Jovana Maletin AI 7/2019- jovanamaletin <br> Djordje Rankvic AI 13/2019-thebananabomb <br> Dusan Stankovic AI 61/2019-StankovicOISIS");
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
