package view;

import controller.DeleteAction;
import controller.EditAction;
import controller.NewAction;

import javax.swing.*;

// Glavni toolbar aplikacije
public class MyToolbar extends JToolBar {

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;

    public MyToolbar() {
        btnAdd = new JButton(new NewAction(false, null));
        btnEdit = new JButton(new EditAction(false));
        btnDelete = new JButton(new DeleteAction(false));

        add(btnAdd);
        // Pravi vertikalni razmak izmedju komponenti
        add(Box.createVerticalStrut(10));
        add(btnEdit);
        add(Box.createVerticalStrut(10));
        add(btnDelete);

        //https://www.tutorialspoint.com/how-to-create-a-vertical-toolbar-in-java
        setOrientation(SwingConstants.VERTICAL);
    }


}
