package view.table;

import model.Cetkica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

// https://www.codejava.net/java-se/swing/jtable-simple-renderer-example
public class ColorCellRenderer extends JList<JLabel> implements TableCellRenderer {

    public ColorCellRenderer() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        setBorder(new EmptyBorder(4, 4, 4, 4));

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        setCellRenderer(colorRenderer);

        if (value instanceof ArrayList) {
            Vector<Cetkica> vector = new Vector<>((ArrayList<Cetkica>) value);
            JLabel[] colors = new JLabel[vector.size()];
            for (int i = 0; i < vector.size(); i++) {
                //https://stackoverflow.com/questions/2854043/converting-a-string-to-color-in-java
                Color color;
                try {
                    Field field = Class.forName("java.awt.Color").getField(vector.elementAt(i).getBoja());
                    color = (Color)field.get(null);
                } catch (Exception e) {
                    color = null;
                }
                JLabel lbl = new JLabel();
                lbl.setText(vector.elementAt(i).getBoja());
                colors[i] = lbl;
            }
            setListData(colors);
        }

        setToolTipText("Double click");

        if (isSelected) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }

        return this;
    }
}
