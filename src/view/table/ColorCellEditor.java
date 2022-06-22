package view.table;

import model.Cetkica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;

public class ColorCellEditor extends AbstractCellEditor implements TableCellEditor {

    ArrayList<Cetkica> cetkice;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        JList<JLabel> list = new JList<>();
        list.setBorder(new EmptyBorder(5, 5, 5, 5));


        ColorRenderer renderer = new ColorRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        list.setCellRenderer(renderer);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);

        if (value instanceof ArrayList) {
            cetkice = (ArrayList<Cetkica>) value;
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
                lbl.setForeground(color);
                lbl.setText(vector.elementAt(i).getBoja());
                colors[i] = lbl;
            }
            list.setListData(colors);
        }

        return scrollPane;
    }

    @Override
    public Object getCellEditorValue() {
        return cetkice;
    }

    @Override
    public boolean isCellEditable(EventObject evt) {
        if (evt instanceof MouseEvent) {
            int clickCount = 2;
            return ((MouseEvent)evt).getClickCount() >= clickCount;
        }
        return true;
    }
}
