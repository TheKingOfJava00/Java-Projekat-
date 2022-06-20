package view.table;

import javax.swing.*;
import javax.swing.table.TableColumn;

// Tabela zaposlenih sa svojim modelom
public class TableZaposleni extends JTable {

    private TableModelZaposleni tableModel;

    public TableZaposleni() {
        tableModel = new TableModelZaposleni();
        setModel(tableModel);
        TableColumn softveriColumn = getColumnModel().getColumn(6);
        softveriColumn.setCellEditor(new ListCellEditor());
        softveriColumn.setCellRenderer(new ListCellRenderer());
        setRowHeight(60);
    }

    public TableModelZaposleni getTableModel() {
        return tableModel;
    }
}
