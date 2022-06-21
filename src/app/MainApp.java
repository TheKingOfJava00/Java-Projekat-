package app;

import javax.swing.*;

public class MainApp {


    public static void main(String[] args) {

        // https://stackoverflow.com/questions/18976990/best-practice-to-start-a-swing-application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppCore.start();
            }
        });
    }


}
