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
        JScrollPane scrollMaterijali = new JScrollPane();
        scrollMaterijali.setViewportView(materijali);
        materijali.setLayoutOrientation(JList.VERTICAL);
        materijali.setListData(new Vector<>(render.getMaterijali()));
        contentPanel.add(scrollMaterijali);
        contentPanel.add(new JLabel("Kamere"));
        JList<String> kamere = new JList<>();
        JScrollPane scrollKamere = new JScrollPane();
        scrollKamere.setViewportView(kamere);
        kamere.setLayoutOrientation(JList.VERTICAL);
        kamere.setListData(new Vector<>(render.getKamere()));
        contentPanel.add(scrollKamere);
        contentPanel.add(new JLabel("Svetlo"));
        contentPanel.add(new JLabel(render.getSvetlo()));
        JList<String> objekti = new JList<>();
        JScrollPane scrollObjekti = new JScrollPane();
        scrollObjekti.setViewportView(objekti);
        objekti.setLayoutOrientation(JList.VERTICAL);
        objekti.setListData(new Vector<>(render.getObjekti()));
        contentPanel.add(new JLabel("Objekti"));
        contentPanel.add(scrollObjekti);

        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle(render.getNaziv());
        dialog.setVisible(true);

        return null;
    }

    @Override
    public Object getCellEditorValue() {
        return render;
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
