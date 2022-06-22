package view.table;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

// Analogno renderer komponenti u tabeli, ovo je za JList
public class ColorRenderer extends DefaultListCellRenderer {

    public ColorRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel lbl = null;
        if (value instanceof JLabel) {
            lbl = (JLabel) value;
            lbl.setBackground(lbl.getForeground());
            // Mora da stoji kako bi se labela prikazala kao boja
            // // https://www.codejava.net/java-se/swing/jtable-simple-renderer-example
            lbl.setOpaque(true);
            lbl.setBorder(new LineBorder(Color.BLACK, 2));
        }

        return lbl;
    }
}
