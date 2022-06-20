package view.table;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;


// Komponenta koja opisuje kako se polje ponasa kad je u edit rezimu
// https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
public class ListCellEditor extends AbstractCellEditor implements TableCellEditor {

    ArrayList<String> list;

    // https://stackoverflow.com/questions/6388453/adding-a-jscrollpane-component-to-a-jtable-column

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        JList<String> list = new JList<>();
        //https://stackoverflow.com/questions/21029653/java-jlist-text-center-align
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);

        //https://www.geeksforgeeks.org/convert-arraylist-to-vector-in-java/
        if (value instanceof ArrayList) {
            this.list = (ArrayList<String>) value;
            Vector<String> vector = new Vector<>(this.list);
            list.setListData(vector);
        }

        return scrollPane;
    }

    // Nakon edita, vracamo listu koja je bila pre toga
    @Override
    public Object getCellEditorValue() {
        return list;
    }

    // http://www.java2s.com/Code/Java/Swing-JFC/SettingtheActivationClickCountforaTableCellEditorinaJTableComponent.htm
    // Stavljamo da cell bude editable na 2 klika
    @Override
    public boolean isCellEditable(EventObject evt) {
        if (evt instanceof MouseEvent) {
            int clickCount = 2;
            return ((MouseEvent)evt).getClickCount() >= clickCount;
        }
        return true;
    }
}
