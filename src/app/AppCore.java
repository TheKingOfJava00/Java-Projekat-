package app;

import model.Database;
import utils.DatabaseUtil;
import view.MainFrame;

public class AppCore {

    // Static polja jer zelimo da im pristupimo iz bilo kog dela aplikacije
    private static MainFrame mainFrame;
    private static Database database;

    private AppCore() {
    }

    public static void start() {
        database = new Database();
        // Popunjava bazu sa generickim podacima
        DatabaseUtil.populateDatabase();
        mainFrame = new MainFrame();
        // Glavni prozor slusa promene database instance
        database.addObserver(mainFrame);
        mainFrame.setVisible(true);
    }


    public static Database getDatabase() {
        return database;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
}