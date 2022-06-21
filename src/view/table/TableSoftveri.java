package view.table;

import javax.swing.*;
import javax.swing.table.TableColumn;

// Tabela softvera sa svojim modelom
public class TableSoftveri extends JTable {

    private TableModelSoftveri tableModel;

    public TableSoftveri() {
        tableModel = new TableModelSoftveri();
        setModel(tableModel);
        TableColumn colCetkice = getColumnModel().getColumn(1);
        TableColumn colModifikatori = getColumnModel().getColumn(2);
        TableColumn colFormati = getColumnModel().getColumn(3);
        TableColumn colAnimationTools = getColumnModel().getColumn(4);
        TableColumn colRender = getColumnModel().getColumn(5);
        colCetkice.setCellRenderer(new ColorCellRenderer());
        colCetkice.setCellEditor(new ColorCellEditor());
        colModifikatori.setCellEditor(new ListCellEditor());
        colModifikatori.setCellRenderer(new ListCellRenderer());
        colFormati.setCellEditor(new ListCellEditor());
        colFormati.setCellRenderer(new ListCellRenderer());
        colAnimationTools.setCellEditor(new ListCellEditor());
        colAnimationTools.setCellRenderer(new ListCellRenderer());
        colRender.setCellEditor(new RenderCellEditor());
        setRowHeight(70);
    }

    public TableModelSoftveri getTableModel() {
        return tableModel;
    }
}
