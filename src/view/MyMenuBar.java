package view;

import controller.*;
import javax.swing.*;

// Glavni meni aplikacije
public class MyMenuBar extends JMenuBar {

    private final JMenu mFile;
    private final JMenu mEdit;
    private final JMenu mHelp;

    public MyMenuBar() {
        mFile = new JMenu("File");
        mEdit = new JMenu("Edit");
        mHelp = new JMenu("Help");


        JMenu mOpen = new JMenu("Open");
        JMenu mNew = new JMenu("New");
        mNew.setIcon(new ImageIcon("src/icons/new.png"));
        mOpen.setIcon(new ImageIcon("src/icons/open.png"));
        JMenuItem itOpenZaposleni = new JMenuItem(new OpenZaposleniAction());
        JMenuItem itOpenSoftveri = new JMenuItem(new OpenSoftveriAction());
        mOpen.add(itOpenZaposleni);
        mOpen.add(itOpenSoftveri);
        JMenuItem itNewZaposleni = new JMenuItem(new NewAction(true, "Zaposleni"));
        JMenuItem itNewSoftveri = new JMenuItem(new NewAction(true, "Softver"));
        mNew.add(itNewZaposleni);
        mNew.add(itNewSoftveri);
        JMenuItem itExit = new JMenuItem(new ExitAction());
        mFile.add(mNew);
        mFile.add(mOpen);
        mFile.add(itExit);

        JMenuItem itEdit = new JMenuItem(new EditAction(true));
        JMenuItem itDelete = new JMenuItem(new DeleteAction(true));
        mEdit.add(itEdit);
        mEdit.add(itDelete);

        JMenuItem itAbout = new JMenuItem(new AboutAction());
        mHelp.add(itAbout);

        this.add(mFile);
        this.add(mEdit);
        this.add(mHelp);
    }
}
