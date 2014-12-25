package ru.kpfu.disciplines.db.gtf;

import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GamedevTeamFinder {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/for apa?user=root&password=1994";
    public static final Color LIGHT = new Color(203, 203, 203);
    public static final Color DARK = new Color(57, 57, 57);

    public static void main(String[] args) {
        final ConnectorDB connector = new ConnectorDB(DB_URL);
        // создаем фрейм в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame(" Gamedev Team Finder", connector);
                mainFrame.setVisible(true);

                // при завершении работы приложения соединение будет разорвано
                mainFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent closing) {
                        connector.shutdownConnection();
                    }
                });
            }
        });
    }
}