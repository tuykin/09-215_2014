package ru.kpfu.disciplines.db.gtf;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class gtfMenuBar extends JMenuBar {

    // кнопки навигации по страницам
    private static JMenu home; // открывает стартовую страницу
    private static JMenu mailbox; // открывает страницу почтового ящика
    private static JMenu personalArea; // открывает личный кабинет
    private static JMenu search; // открывает поисковик по людям/командам

    // информационные кнопки
    private JMenu about; // информация о приложении
    private JMenu contact; // контактная информация
    private JMenu terms; // правила поведения
    private JMenu privacy; // соглашение о конфиденциальности

    // кнопка с выпадающим списком: "Профиль", "Настройки", "Выйти с аккаунта"
    private static JMenu nicknameWithList;
    // 3 кнопки из этого списка:
    private JMenuItem profile; // открывает страницу с профилем пользователя
    private JMenuItem settings; // открывает страницу настроек
    private JMenuItem logout; // выход из аккаунта

    // конструктор по умолчания для создания панели меню
    gtfMenuBar() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addNavigationButtons();
        addInfoButtons();
        addNicknameWithList();
        setNavigationAndNicknameVisible(false);
    }

    // добавляет кнопки навигации по страницам на панель меню
    // до момента входа по логину кнопки не видны
    private void addNavigationButtons() {
        home = new JMenu("Home");
        mailbox = new JMenu("Mailbox");
        personalArea = new JMenu("Personal area");
        search = new JMenu("Search");

        add(home);
        add(mailbox);
        add(personalArea);
        add(search);
        add(Box.createHorizontalStrut(50));

        home.setPreferredSize(new Dimension(45, 21));
        mailbox.setPreferredSize(new Dimension(55, 21));
        personalArea.setPreferredSize(new Dimension(90, 21));
        search.setPreferredSize(new Dimension(54, 21));

        home.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (home.isEnabled()) {
                    MainFrame.showWelcomePage();
                }
            }
        });

        mailbox.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(mailbox.isEnabled()) {
                    MainFrame.showMailbox();
                }
            }
        });

        personalArea.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(personalArea.isEnabled()) {
                    MainFrame.showPersonalArea();
                }
            }
        });
    }

    // добавляет информационные кнопки на панель меню
    private void addInfoButtons() {
        about = new JMenu("About");
        contact = new JMenu("Contact");
        terms = new JMenu("Terms");
        privacy = new JMenu("Privacy");

        add(about);
        add(contact);
        add(terms);
        add(privacy);
        add(Box.createHorizontalStrut(50));

        about.setPreferredSize(new Dimension(48, 21));
        contact.setPreferredSize(new Dimension(56, 21));
        terms.setPreferredSize(new Dimension(50, 21));
        privacy.setPreferredSize(new Dimension(55, 21));
    }

    // добавляет выпадающий список с тремя кнопками на панель меню
    // текст самой кнопки задается в момент входа по логину-паролю
    // текст кнопки - никнейм пользователя
    // до момента входа по логину кнопка не видна
    private void addNicknameWithList() {
        nicknameWithList = new JMenu("");
        add(nicknameWithList);

        profile = new JMenuItem("Profile");
        settings = new JMenuItem("Settings");
        logout = new JMenuItem("Log out");

        nicknameWithList.add(profile);
        nicknameWithList.add(settings);
        nicknameWithList.add(logout);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.showStartPage();
                MainFrame.deleteOtherPages();
                setNavigationAndNicknameVisible(false);
                setNickNameOnMenu("");
            }
        });
    }

    // делает кнопки навигации и кнопку со списком видимыми/невидимыми
    public static void setNavigationAndNicknameVisible(boolean areVisible) {
        home.setVisible(areVisible);
        mailbox.setVisible(areVisible);
        personalArea.setVisible(areVisible);
        search.setVisible(areVisible);
        nicknameWithList.setVisible(areVisible);
    }

    // задать логин пользователя в компонент меню в правой части экрана
    public static void setNickNameOnMenu(String name) {
        nicknameWithList.setText(name);
    }
}