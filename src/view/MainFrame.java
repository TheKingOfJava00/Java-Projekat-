package view;

import observer.Observer;
import view.table.TableSoftveri;
import view.table.TableZaposleni;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// Glavni prozor aplikacije
public class MainFrame extends JFrame implements Observer {

    private MyMenuBar myMenuBar;
    private MyToolbar myToolbar;
    private JTabbedPane content;
    private JPanel statusBar;
    private TableZaposleni tableZaposleni;
    private TableSoftveri tableSoftveri;

    public MainFrame() {
        init();
        addComponents();
    }

    private void init() {
        this.setTitle("Animation Software");
        // Dohvatamo velicinu ekrana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Sirina i visina na 3/4 ekrana
        int w = (int) (screenSize.width * 0.75);
        int h = (int) (screenSize.height * 0.75);
        this.setSize(w, h);
        // Centriramo prozor
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents() {

        myMenuBar = new MyMenuBar();
        myToolbar = new MyToolbar();

        content = new JTabbedPane();
        content.setBorder(new EmptyBorder(20, 40, 10, 20));
        initContent();

        statusBar = new JPanel();
        statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.X_AXIS));
        statusBar.setPreferredSize(new Dimension(this.getWidth(), 30));
        // Dohvatamo danasnji datum i formatiramo ga - dd.MM.yyyy
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        JLabel lbStatus = new JLabel(date);
        // Pozicionira labelu uz desnu stranu
        statusBar.add(Box.createHorizontalGlue());
        statusBar.add(lbStatus);

        this.getContentPane().add(BorderLayout.NORTH, myMenuBar);
        this.getContentPane().add(BorderLayout.CENTER, content);
        this.getContentPane().add(BorderLayout.SOUTH, statusBar);
        this.getContentPane().add(BorderLayout.WEST, myToolbar);
    }

    // Pravimo tabele softvera i zaposlenih, lepimo na JTabbedPane(content)
    private void initContent() {
        tableZaposleni = new TableZaposleni();
        tableSoftveri = new TableSoftveri();
        content.addTab("Zaposleni", new JScrollPane(tableZaposleni));
        content.addTab("Softveri", new JScrollPane(tableSoftveri));
    }

    // Menja aktivni tab - Softver/Zaposleni
    public void changeTab(int index) {
        content.setSelectedIndex(index);
    }


    @Override
    public void update(Object notification) {
        // Brisemo sve iz JTabbedPanea i iscrtavamo ponovo
        content.removeAll();
        initContent();
    }

    public TableZaposleni getTableZaposleni() {
        return tableZaposleni;
    }

    public TableSoftveri getTableSoftveri() {
        return tableSoftveri;
    }

    public JTabbedPane getContent() {
        return content;
    }
}
