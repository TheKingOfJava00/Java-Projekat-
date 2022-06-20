package view.table;

import model.Render;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Vector;

public class RenderCellEditor extends AbstractCellEditor implements TableCellEditor {

    private Render render;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        this.render = (Render) value;

        JDialog dialog = new JDialog();
        dialog.setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel(new GridLayout(4, 2));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.add(new JLabel("Materijali"));
        JList<String> materijali = new JList<>();
        
        return null;
    }

   
    }
