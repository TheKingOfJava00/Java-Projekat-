package view.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


// Klasa koja odredjuje kako ce se odredjene komponente prikazivati u tabeli
// https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
public class ListCellRenderer extends DefaultTableCellRenderer {

    //https://stackoverflow.com/questions/9955595/how-to-display-multiple-lines-in-a-jtable-cell
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JList<String> list = new JList<>();
        //https://stackoverflow.com/questions/21029653/java-jlist-text-center-align
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);


        //https://www.geeksforgeeks.org/convert-arraylist-to-vector-in-java/
        if (value instanceof ArrayList) {
            Vector<String> vector = new Vector<String>((ArrayList<String>) value);
            list.setListData(vector);
        }

        if (isSelected) {
            list.setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            list.setBackground(UIManager.getColor("Table.background"));
        }

        list.setToolTipText("Double click to expand");

        return list;
    }
}
