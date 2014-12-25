package ru.kpfu.disciplines.db.gtf.pages;

import ru.kpfu.disciplines.db.gtf.GamedevTeamFinder;
import ru.kpfu.disciplines.db.gtf.MainFrame;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class WelcomePage extends JPanel {
    public WelcomePage() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel forTitle = new JPanel();
        JLabel title = new JLabel("Welcome, " + StartPage.getCurrentUser() + "!");
        Font font = new Font("welcomeFont", Font.PLAIN, 24);
        title.setFont(font);
        title.setBackground(GamedevTeamFinder.LIGHT);
        title.setForeground(GamedevTeamFinder.DARK);
        forTitle.add(title);
        add(forTitle);

        JPanel forVariants = new JPanel();
        JPanel variants = new JPanel(new GridLayout(3, 2, 20, 20));
        forVariants.add(variants);
        add(forVariants);

        JLabel goMail = new JLabel("You may check your mailbox:", SwingConstants.RIGHT);
        JLabel goPA = new JLabel("Or enter your personal area to start team assembly processes:", SwingConstants.RIGHT);
        JLabel goSettings = new JLabel("Or maybe you'd prefer to change settings:", SwingConstants.RIGHT);
        JButton toMail = new JButton("Way to mailbox");
        JButton toPA = new JButton("Way to personal area");
        JButton toSettings = new JButton("Way to change settings");

        variants.add(goMail);
        variants.add(toMail);
        variants.add(goPA);
        variants.add(toPA);
        variants.add(goSettings);
        variants.add(toSettings);

        toMail.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.showMailbox();
            }
        });

        toPA.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.showPersonalArea();
            }
        });

        toSettings.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.showSettingsPage();
            }
        });
    }
}